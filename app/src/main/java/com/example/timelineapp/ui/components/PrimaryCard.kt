package com.example.timelineapp.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun PrimaryCard(
    modifier: Modifier = Modifier,
    elevation: Dp = 3.dp,
    backgroundColor: Color = Color.White,
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.fillMaxSize(),
        elevation = elevation,
        backgroundColor = backgroundColor
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if (onClick != null && onLongClick != null)
                        Modifier.combinedClickable(
                            onClick = onClick,
                            onLongClick = onLongClick
                        )
                    else if (onClick != null)
                        Modifier.clickable {
                            onClick()
                        }
                    else if (onLongClick != null)
                        Modifier.combinedClickable(
                            onClick = {},
                            onLongClick = onLongClick
                        )
                    else
                        Modifier
                ),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}
