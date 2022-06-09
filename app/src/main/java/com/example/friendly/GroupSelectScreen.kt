package com.example.friendly


import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.friendly.ui.theme.FriendlyTheme
import com.example.friendly.ui.theme.Gray200



@Composable
fun GroupBottom(
    groupName: String,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Gray200,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .clickable { onItemClick() }
            .shadow(
                elevation = 8.dp,
                shape = MaterialTheme.shapes.medium
            )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.height(120.dp)
        ) {
            Text(
                text = groupName,
                style = MaterialTheme.typography.h5,
                modifier = modifier
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GroupsGrid(
    groupSelectViewModel: GroupSelectViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
    ) {
        items(groupSelectViewModel.groupList) { item ->
            GroupBottom(
                groupName = item,
                onItemClick = {}
            )
        }
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun GroupsGridPreview() {
    FriendlyTheme {
        GroupsGrid()
    }
}

@Composable
fun GroupScreen(
    groupSelectViewModel: GroupSelectViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Groups",
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .paddingFromBaseline(top = 50.dp, bottom = 8.dp)
        )
        Divider(
            color = Color.Gray,
            thickness = 2.dp,
            modifier = Modifier.padding(16.dp)
        )
        GroupsGrid(groupSelectViewModel)
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun GroupScreenPreview() {
    FriendlyTheme {
        GroupScreen()
    }
}

@Composable
fun GroupScreenFull(
    groupSelectViewModel: GroupSelectViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    FriendlyTheme {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = modifier
        ) {
            Image(
                painter = painterResource(R.drawable.background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxWidth()
            )
            GroupScreen(groupSelectViewModel)
        }
    }
}
@Preview(widthDp = 360, heightDp = 640)
@Composable
fun GroupScreenFullPreview() {
    GroupScreenFull()
}
