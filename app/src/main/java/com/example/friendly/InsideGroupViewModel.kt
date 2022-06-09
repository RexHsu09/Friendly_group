package com.example.friendly

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class InsideGroupViewModel: ViewModel() {
    var readyToHatch by mutableStateOf(false)

    private var _newHatchedMonster = getMyCollection().toMutableStateList()
    val newHatchedMonster: MonsterData
        get() = _newHatchedMonster.last()

    private val _monstersInPark = getMonstersInPark().toMutableStateList()
    val monstersInPark: List<MonsterData>
        get() = _monstersInPark

    fun hatch(){}
}

private fun getMyCollection(): List<MonsterData> {
    return ownedMonsterList
}

private fun getMonstersInPark(): List<MonsterData> {
    return monstersInParkList
}

data class MonsterData(
    @DrawableRes val picture: Int,
    val name: String
)

val monstersInParkList = listOf<MonsterData>(
    MonsterData(R.drawable.monster_1, "monster_1"),
    MonsterData(R.drawable.monster_2, "monster_2"),
    MonsterData(R.drawable.monster_3, "monster_3"),
    MonsterData(R.drawable.monster_4, "monster_4")
)

data class TaskData(
    val description: String,
    val award: Float,
    val progress: Float
)

val taskList = listOf(
    TaskData("所有群組成員連續記帳三天", 0.1f, 0.75f),
    TaskData("吃早餐了沒? 集滿10次早餐紀錄", 0.15f, 0.5f),
    TaskData("有錢人的煩惱 - 集滿3筆上千元消費", 0.1f, 0.8f),
    TaskData("努力又孝順的孩子 - 集滿5筆打工紀錄", 0.1f, 0.15f),
    TaskData("記帳鬧鐘 - 累計100次記帳提醒", 0.05f, 0.9f)
)