package com.example.timelineapp.ui.bestitinerary

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timelineapp.ui.components.PrimaryCard

@ExperimentalUnitApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun PointInfo(
    cardName: String,
    title: String,
    phone: String,
    address: String,
    rulesTextColor: Color = Color.Black,
    image: Int,
    onClick: () -> Unit = {}
) {
    PrimaryCard(
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .padding(
                    vertical = 4.dp,
                    horizontal = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .padding(horizontal = 8.dp),
                painter = painterResource(image),
                contentDescription = null
            )

            Spacer(Modifier.size(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = cardName,
                    color = Color.Black,
                    maxLines = 1,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                if (title.isNotEmpty()) {
                    Text(
                        text = title,
                        color = Color.Black,
                        maxLines = 1
                    )
                }
                Text(
                    text = phone,
                    color = Color.Black,
                    maxLines = 1
                )
                Text(
                    text = address,
                    color = rulesTextColor,
                    maxLines = 1
                )
            }
        }
    }
}
