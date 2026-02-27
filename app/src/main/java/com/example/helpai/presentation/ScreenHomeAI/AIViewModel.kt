package com.example.helpai.presentation.ScreenHomeAI

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helpai.Domain.DomainModels.ModelsDomain
import com.example.helpai.Domain.UseCase.LogicUse
import com.example.helpai.presentation.ModelsPresentation.StateIntent
import com.example.helpai.presentation.ModelsPresentation.StateIntent.Intent.*
import com.example.helpai.presentation.ScreenHomeAI.ChatMessage.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


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
                        messagesList = it.messagesList + User(curentText,getCurrentTime()),
                        textField = "",
                        isLoading = true
                    )
                }

                _state.update {
                    it.copy(
                        messagesList = it.messagesList + ChatMessage.Typing
                    )
                }


                addServerMassage(textServer = curentText)

            }

            is LoadResponse -> {
                addServerMassage(textServer = intent.text)
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

    private fun addServerMassage(textServer: String){

        viewModelScope.launch {

            LogicUse.getResponsUse(textServer)
                .catch { e ->
                    _state.update { it.copy(isLoading = false) }
                }.collectLatest { respons ->
                    Log.d("AIViewModel", "Server response: ${respons.respons}")
                _state.update {
                    it.copy(
                        messagesList = it.messagesList.filterNot {
                            it is ChatMessage.Typing
                        } + ChatMessage.Server(respons.respons,getCurrentTime())


                    )

                }

            }


        }

    }

}



