package com.example.timelineapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.timelineapp.ui.theme.Purple500

@Composable
fun PrimaryButton(
    title: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Button(
        modifier = Modifier
            .padding(
                16.dp
            )
            .clip(
                RoundedCornerShape(
                    8.dp
                )
            )
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Purple500,
            disabledBackgroundColor = Color.LightGray,
            contentColor = Color.Black,
            disabledContentColor = Color.Black
        ),
        enabled = enabled,
        onClick = {
            onClick.invoke()
        },
    ) {
        Text(
            text = title,
            color = Color.White
        )
    }
}