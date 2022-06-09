package com.example.friendly


import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.friendly.ui.theme.Brown400
import com.example.friendly.ui.theme.FriendlyTheme
import com.example.friendly.ui.theme.Orange400
import com.example.friendly.ui.theme.Yellow400

@Composable
fun MemberCard(
    userViewModel: UserViewModel,
    memberData: UserData,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.small,
        backgroundColor = Yellow400,
        border = BorderStroke(4.dp, Brown400),
        elevation = 8.dp,
        modifier = Modifier
            .width(350.dp)
            .padding(8.dp)
            .clickable {}
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.remind),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(2.dp)
                    .align(Alignment.CenterEnd)
                    .height(50.dp)
                    .offset(x = (-16).dp)
                    .clickable { userViewModel.remind(memberData) }
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(4.dp)
            ) {
                Image(
                    painter = painterResource(memberData.profile),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(60.dp)
                        .padding(4.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = memberData.name,
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = "任務完成數: ${memberData.completedTasksNum}",
                        style = MaterialTheme.typography.h6.copy(fontSize = 14.sp)
                    )
                }
            }
        }
    }
}
//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun MemberCardPreview() {
//    FriendlyTheme {
//        MemberCard(MemberData(R.drawable.member_1, 56, "Wu Shang Hong"))
//    }
//}

@Composable
fun MemberList(
    userViewModel: UserViewModel = viewModel(),
    messageViewModel: MessageViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(userViewModel.memberDataList) { item ->
            MemberCard(
                userViewModel = userViewModel,
                memberData = item
            )
        }
    }
}

@Composable
fun MemberScreen(
    userViewModel: UserViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Box {
        Image(
            painter = painterResource(R.drawable.light_group_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            TopBar(
                onClose = {},
                title = "Members"
            )
            MemberList(userViewModel)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun MemberScreenPreview() {
    FriendlyTheme {
        MemberScreen()
    }
}