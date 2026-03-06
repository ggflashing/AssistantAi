package com.example.helpai.presentation.ScreenHomeAI

import android.util.Log
import android.util.Log.e
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helpai.Domain.DomainModels.ModelsDomain
import com.example.helpai.Domain.UseCase.LogicUse
import com.example.helpai.presentation.ModelsPresentation.StateIntent
import com.example.helpai.presentation.ModelsPresentation.StateIntent.Intent.*
import com.example.helpai.presentation.ScreenHomeAI.ChatMessage.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.collections.plus


sealed class ChatMessage{
    data class User(val textuser: String, val currentTime: String) : ChatMessage()

    data class Server(val textserver: List<ModelsDomain>, val currentTime: String) : ChatMessage()

    object Typing : ChatMessage()

}

@HiltViewModel
class AIViewModel @Inject constructor(

    private val LogicUse: LogicUse

) : ViewModel() {

    private val _state = MutableStateFlow(StateIntent.State())
    val state: StateFlow<StateIntent.State> = _state

    init {
        observeChatFlow()
    }

    private fun observeChatFlow() {
        viewModelScope.launch {
            LogicUse.chatFlow.collect { messages ->
                _state.update { state ->
                    val mappedMessages = messages.map { domain ->
                        if (domain.role == "user") {
                            ChatMessage.User(domain.text, getCurrentTime())
                        } else {
                            ChatMessage.Server(listOf(domain), getCurrentTime())
                        }
                    }

                    state.copy(
                        messagesList = mappedMessages
                    )

                }

            }
        }
    }

    fun getCurrentTime(): String {
        val formatter = java.text.SimpleDateFormat("HH:mm", java.util.Locale.getDefault())
        return formatter.format(java.util.Date())
    }

    fun Chat(intent: StateIntent.Intent) {
        when (intent) {

            is SendMessage -> {
                val curentText = _state.value.textField

                if (curentText.isBlank()) return

                _state.update {
                    it.copy(
                        messagesList = it.messagesList + User(curentText, getCurrentTime()),
                        textField = "",
                        isLoading = true
                    )
                }

                sendMessage(text = curentText)

            }

            is LoadResponse -> {
                sendMessage(text = intent.text)
            }

            is EnterText -> {
                _state.value = _state.value.copy(
                    textField = intent.textfield

                )

            }
            is SelectButton -> {
                _state.update {
                    it.copy(textField = intent.text)
                }

            }
        }
    }

//    private fun addUserMassage(textUser: String) {
//        _state.update {
//            it.copy(
//                messagesList = it.messagesList + ChatMessage.User(textUser),
//            )
//
//        }
//
//    }

    private fun sendMessage(text: String) {
        viewModelScope.launch {
            try {
                LogicUse.sendMessage(text).collectLatest { response ->

                    Log.d("AIViewModel", "Server response: $response")

                    _state.update { state ->
                        state.copy(
                            messagesList = state.messagesList +
                                    ChatMessage.Server(response, getCurrentTime()),
                            isLoading = false
                        )
                    }
                }
            }catch (e: Exception) {
                Log.e("AIViewModel", "Error sending message", e)
                _state.update { it.copy(isLoading = false) }
            }

        }
    }
}






