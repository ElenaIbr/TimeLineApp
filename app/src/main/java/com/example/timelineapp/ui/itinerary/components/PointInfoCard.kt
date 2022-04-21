package com.example.timelineapp.ui.itinerary

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.example.timelineapp.R
import com.yeocak.timelineview.TimelineView

@OptIn(
    ExperimentalUnitApi::class,
    ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class
)
@Composable
fun PointInfoCard(
    cardName: String,
    type: TimelineView.NodeType,
    title: String,
    phone: String,
    address: String,
    image: Int = R.drawable.ic_destination
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            )
    ) {
        TimelineView.SingleNode(color = Color(33, 33, 33),
            nodeType = type,
            nodeSize = 30f,
            modifier = Modifier
                .padding(
                    horizontal = 20.dp
                ),
            isChecked = false,
            isDashed = true)

        PointInfo(
            cardName = cardName,
            title = title,
            phone = phone,
            address = address,
            image = image
        )
    }
}
