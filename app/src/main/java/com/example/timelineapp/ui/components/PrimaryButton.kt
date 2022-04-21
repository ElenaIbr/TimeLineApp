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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.example.timelineapp.R

@Composable
fun PrimaryButton(
    title: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Button(
        modifier = Modifier
            .padding(
                dimensionResource(id = R.dimen.app_padding)
            )
            .clip(
                RoundedCornerShape(
                    dimensionResource(id = R.dimen.app_small_padding)
                )
            )
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.teal_700),
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