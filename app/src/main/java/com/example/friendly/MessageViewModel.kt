package com.example.friendly

import androidx.annotation.DrawableRes
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class MessageViewModel: ViewModel() {
    private val _messageHistoryData = getMessageHistoryData().toMutableStateList()
    val messageHistoryData: List<MessageData>
        get() = _messageHistoryData

    fun sendMessage(inputValue: String) {

    }
}

private fun getMessageHistoryData(): List<MessageData>{
    return messageHistory
}

data class MessageData(
    @DrawableRes val profile: Int,
    val userId: Int,
    val message: String
)

val messageHistory = listOf(
    MessageData(R.drawable.friend_1, 1, "There are 5 tasks remaining."),
    MessageData(R.drawable.member_1, 2, "Let's go!"),
    MessageData(R.drawable.friend_2, 3, "You forgot to record your breakfast")
)