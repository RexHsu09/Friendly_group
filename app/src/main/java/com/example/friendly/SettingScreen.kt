package com.example.friendly.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.friendly.R
import com.example.friendly.UserViewModel


@Composable
fun MemberBigCard(
    name: String,
    @DrawableRes profile: Int,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    Surface(
        color = Gray200,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .clickable { onItemClick() }
            .heightIn(150.dp)
            .shadow(
                elevation = 8.dp,
                shape = MaterialTheme.shapes.medium
            )
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(profile),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )
            Text(
                text = name,
                style = MaterialTheme.typography.h5,
                modifier = modifier
            )
        }
    }
}
//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun MemberBigCardPreview() {
//    FriendlyTheme {
//        MemberBigCard(
//            name = R.string.friend_1,
//            profile = R.drawable.friend_1,
//            onItemClick = {}
//        )
//    }
//}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ConfirmMemberGrid(
    userViewModel: UserViewModel,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        modifier = modifier
    ) {
        items(userViewModel.selectedFriends) { item ->
            MemberBigCard(
                name = item.name,
                profile = item.profile,
                onItemClick = {}
            )
        }
    }
}

@Composable
fun Settings(
    userViewModel: UserViewModel,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { }
                        .size(35.dp)
                )
                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.h4
                )
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { }
                        .size(35.dp)
                )
            }
            Divider(
                color = Color.Gray,
                thickness = 2.dp,
                modifier = Modifier.absolutePadding(left = 16.dp, right = 16.dp)
            )
            TextField(
                value = userViewModel.groupName,
                onValueChange = { userViewModel.groupName = it },
                placeholder = {
                    Text("Group Name")
                },
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 30.dp)
                    .padding(16.dp)
            )
            Divider(
                color = Color.Gray,
                thickness = 2.dp,
                modifier = Modifier.absolutePadding(left = 16.dp, right = 16.dp)
            )
            TextField(
                value = userViewModel.setMaximum,
                onValueChange = { userViewModel.setMaximum = it },
                placeholder = {
                    Text("Maximum Number of Members")
                },
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 30.dp)
                    .padding(16.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = modifier
            ) {
                Text(
                    text = "Members:",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(8.dp)
                )
            }
            ConfirmMemberGrid(userViewModel)
        }
    }
}
//@Preview (showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun SettingsPreview() {
//    FriendlyTheme {
//        Settings()
//    }
//}

@Composable
fun SettingsScreen(
    userViewModel: UserViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Settings(userViewModel)
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
            .offset(y = (-30).dp)
    ) {
        Surface(
            color = Orange200,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .clickable { userViewModel.createGroup() }
                .shadow(
                    elevation = 8.dp,
                    shape = MaterialTheme.shapes.medium
                )
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(220.dp)
                    .heightIn(40.dp)
            ) {
                Text(
                    text = "Confirm",
                    style = MaterialTheme.typography.h5,
                    modifier = modifier
                )
            }
        }
    }
}
//@Preview (showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun SettingsScreenPreview() {
//    FriendlyTheme {
//        SettingsScreen()
//    }
//}