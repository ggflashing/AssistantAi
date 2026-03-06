package com.example.helpai.presentation.ModelsPresentation

import com.example.helpai.presentation.ScreenHomeAI.ChatMessage

interface StateIntent {

    sealed interface Intent {
        object SendMessage : Intent
        data class LoadResponse(val text: String) : Intent
        data class EnterText(val textfield: String): Intent

        data class SelectButton(val text: String) : Intent

    }

    data class State(
        val messagesList: List<ChatMessage> = emptyList(),
        val textField: String = "",
        val isLoading: Boolean = false,
        val ListQustion: List<String> = listOf(
            "Обьясни жизненный цикл Activity",
            "Что такое ViewModel",
            "Как работает корутины?",
            "Чем отличается Fragment от Activity?"
        )

    ){

        val falseButton : Boolean
            get() = textField.isNotBlank()

        val hideQustion: Boolean
            get() = textField.isBlank() && messagesList.isEmpty()

    }

}