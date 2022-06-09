package com.example.friendly

import androidx.annotation.DrawableRes
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    var inviteSelected: MutableList<UserData> = mutableListOf()

    private val _selectedDataList = getSelectedList().toMutableStateList()
    val selectedDataList: List<UserData>
        get() = _selectedDataList

    private val _memberDataList = getMemberList().toMutableStateList()
    val memberDataList: List<UserData>
        get() = _memberDataList

    private val _friendDataList = getFriendList().toMutableStateList()
    val friendDataList: List<UserData>
        get() = _friendDataList

    fun addFriend(userData: UserData){}
    fun remind(userData: UserData){}
    fun invite(invitedUsers: MutableList<UserData>){}
    fun select(userData: UserData, selectState: Boolean){}
}

private fun getFriendList(): List<UserData>{
    return friendDataList
}

private fun getMemberList(): List<UserData>{
    return memberDataList
}

private fun getSelectedList(): List<UserData>{
    return selectedDataList
}

data class RecordData(
    val time: String,
    val description: String,
    val incomeOrExpense: Int
)

data class UserData(
    @DrawableRes val profile: Int,
    val name: String,
    val completedTasksNum: Int,
    val records: List<RecordData>,
    val ownedMonsters: List<MonsterData>
)

val recordList = listOf(
    RecordData("7:40", "早餐", -50),
    RecordData("12:00", "午餐", -100),
    RecordData("18:30", "晚餐", -200),
    RecordData("21:00", "家教", 300),
    RecordData("21:30", "宵夜", -60)
)

val ownedMonsterList = listOf(
    MonsterData(R.drawable.monster_1, "monster_1"),
    MonsterData(R.drawable.monster_2, "monster_2"),
    MonsterData(R.drawable.monster_3, "monster_3"),
    MonsterData(R.drawable.monster_4, "monster_4"),
    MonsterData(R.drawable.monster_5, "monster_5")
)

val friendDataList = listOf(
    UserData(
        profile = R.drawable.member_1,
        name = "Wu Shang Hong",
        completedTasksNum = 56,
        records = recordList,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_2,
        name = "Sophia",
        completedTasksNum = 40,
        records = recordList,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_3,
        name = "Lucy",
        completedTasksNum = 31,
        records = recordList,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_4,
        name = "Alice",
        completedTasksNum = 23,
        records = recordList,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_5,
        name = "Christen",
        completedTasksNum = 12,
        records = recordList,
        ownedMonsters = ownedMonsterList
    )
)

val memberDataList = listOf(
    UserData(
        profile = R.drawable.member_1,
        name = "Wu Shang Hong",
        completedTasksNum = 56,
        records = recordList,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_2,
        name = "Sophia",
        completedTasksNum = 40,
        records = recordList,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_3,
        name = "Lucy",
        completedTasksNum = 31,
        records = recordList,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_4,
        name = "Alice",
        completedTasksNum = 23,
        records = recordList,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_5,
        name = "Christen",
        completedTasksNum = 12,
        records = recordList,
        ownedMonsters = ownedMonsterList
    )
)

val selectedDataList = listOf(
    UserData(
        profile = R.drawable.member_1,
        name = "Wu Shang Hong",
        completedTasksNum = 56,
        records = recordList,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_2,
        name = "Sophia",
        completedTasksNum = 40,
        records = recordList,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_3,
        name = "Lucy",
        completedTasksNum = 31,
        records = recordList,
        ownedMonsters = ownedMonsterList
    )
)