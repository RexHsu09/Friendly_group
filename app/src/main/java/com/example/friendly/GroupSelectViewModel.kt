package com.example.friendly

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class GroupSelectViewModel: ViewModel() {
    private val _groupsList = getGroupsList().toMutableStateList()
    val groupList: List<String>
        get() = _groupsList
}

fun getGroupsList(): List<String> {
    return groupNames
}
private val groupNames = listOf(
    "GroupA", "GroupB", "GroupC", "GroupD"
)