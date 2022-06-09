package com.example.friendly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.friendly.ui.theme.FriendlyTheme
import com.example.friendly.ui.theme.SettingsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FriendlyTheme {
                GroupSelectScreen()
//                InvitePage()
//                SettingsScreen()
//                GroupScreen()
//                ChatRoomScreen()
//                MemberScreen()
//                TasksScreen()
//                ProfileScreen(memberData = memberDataList[0])
            }
        }
    }
}















