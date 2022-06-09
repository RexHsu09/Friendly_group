package com.example.friendly

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import com.example.friendly.ui.theme.Brown100
import com.example.friendly.ui.theme.FriendlyTheme
import com.example.friendly.ui.theme.Gray200
import com.example.friendly.ui.theme.Orange200

@Composable
fun RecordListShow(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .height(160.dp)
    ) {
        items(recordList) { item ->
            recordCard(recordData = item)
        }
    }
}

@Composable
fun recordCard(
    recordData: RecordData,
    modifier: Modifier = Modifier
) {
    Card(
        backgroundColor = Gray200,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .width(300.dp)
            .padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = recordData.time,
                style = MaterialTheme.typography.h5
            )
            Text(
                text = recordData.description,
                style = MaterialTheme.typography.h5
            )
            Text(
                text = "${recordData.incomeOrExpense}元",
                style = MaterialTheme.typography.h5
            )
        }
    }
}



@Composable
fun OwnedMonsterCard(
    @DrawableRes monster: Int,
    modifier: Modifier = Modifier
) {
    Card(
        shape = CircleShape,
        backgroundColor = Gray200,
        modifier = Modifier
            .absolutePadding(left = 48.dp)
    ) {
        Box {
            Image(
                painter = painterResource(monster),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp)
                    .size(80.dp)
            )
        }
    }
}

@Composable
fun OwnedMonsterList(modifier: Modifier = Modifier) {
    LazyRow(modifier = Modifier.padding(8.dp)) {
        items(ownedMonsterList) { item ->
            OwnedMonsterCard(monster = item.picture)
        }
    }
}



@Composable
fun ProfileCard(
    userViewModel: UserViewModel = viewModel(),
    userData: UserData,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.large,
        backgroundColor = Brown100,
        modifier = Modifier
            .width(350.dp)
            .height(700.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                Image(
                    painter = painterResource(userData.profile),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(170.dp)
                        .padding(16.dp)
                )
                Text(
                    text = userData.name,
                    style = MaterialTheme.typography.h5.copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "任務完成數: ${userData.completedTasksNum}",
                    style = MaterialTheme.typography.h5
                )
                RecordListShow()
                OwnedMonsterList()
            }
            Card(
                backgroundColor = Orange200,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .clickable {}
            ) {
                Box(modifier = Modifier.clickable { userViewModel.addFriend(userData) }){
                    Text(
                        color = Color.White,
                        text = "Add Friend",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}


@Composable
fun ProfileScreen(
    userViewModel: UserViewModel = viewModel(),
    memberData: UserData,
    modifier: Modifier = Modifier
) {
    Box {
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            TopBar(onClose = {},"Profile")
            ProfileCard(userViewModel, memberData)
        }
    }
}

//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun ProfileScreenPreview() {
//    FriendlyTheme {
//        ProfileScreen(memberDataList[0])
//    }
//}