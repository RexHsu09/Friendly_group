package com.example.friendly

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.friendly.ui.theme.FriendlyTheme
import com.example.friendly.ui.theme.Orange400

@Composable
fun Bell(
    newRemind: Boolean, //是否有新的記帳提醒
    modifier: Modifier = Modifier) {
    Box{
        IconButton(
            onClick = { /*TODO*/ },
            enabled = true,
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(
                    color = Orange400
                )
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                tint = Color.White
            )
        }
        if (newRemind) {
            Surface(
                shape = CircleShape,
                color = Color.Red,
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.TopEnd)
            ) {}
        }
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun BellPreview() {
    FriendlyTheme {
        Bell(newRemind = true)
    }
}