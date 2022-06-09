package com.example.friendly

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.friendly.ui.theme.FriendlyTheme

@Composable
fun BottomMenuItem(
    @StringRes text: Int,
    @DrawableRes drawable: Int,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            modifier = Modifier.size(36.dp)
        )
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.paddingFromBaseline(top = 10.dp, bottom = 5.dp)
        )
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun BottomMenuItemPreview() {
    FriendlyTheme {
        BottomMenuItem(
            text = R.string.Chart,
            drawable = R.drawable.chart_menu_icon,
            onItemClick = {}
        )
    }
}

@Composable
fun BottomMenu(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(R.drawable.menu_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxWidth()
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .offset(y = 25.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
            ) {
                BottomMenuItem(
                    text = R.string.Chart,
                    drawable = R.drawable.chart_menu_icon,
                    onItemClick = {}
                )
                BottomMenuItem(
                    text = R.string.Record,
                    drawable = R.drawable.record_menu_icon,
                    onItemClick = {}
                )
            }
            Image(
                painter = painterResource(R.drawable.add_menu_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = -10.dp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
            ) {
                BottomMenuItem(
                    text = R.string.Group,
                    drawable = R.drawable.group_menu_icon,
                    onItemClick = {}
                )
                BottomMenuItem(
                    text = R.string.Home,
                    drawable = R.drawable.home_menu_icon,
                    onItemClick = {}
                )
            }
        }
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun BottomMenuPreview() {
    FriendlyTheme {
        BottomMenu()
    }
}