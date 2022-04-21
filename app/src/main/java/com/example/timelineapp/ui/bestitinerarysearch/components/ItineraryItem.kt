package com.example.timelineapp.ui.bestitinerarysearch.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.timelineapp.R
import com.example.timelineapp.data.database.model.StorageItinerary

@Composable
fun ItineraryItem(
    itinerary: StorageItinerary,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.itinerary_item_horizontal_padding),
                end = dimensionResource(id = R.dimen.itinerary_item_horizontal_padding),
                bottom = dimensionResource(id = R.dimen.itinerary_item_vertical_padding)
            ),
        shape = RoundedCornerShape(
            dimensionResource(id = R.dimen.itinerary_item_corner)
        ),
        elevation = dimensionResource(id = R.dimen.itinerary_elevation),
        backgroundColor = Color.LightGray
    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.app_padding),
                    vertical = dimensionResource(id = R.dimen.app_small_padding)
                )
                .clickable {
                    onClick.invoke()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = itinerary.flightTitle,
                    fontSize = 16.sp
                )
            }
            Spacer(
                modifier = Modifier.width(
                    dimensionResource(id = R.dimen.app_padding)
                )
            )
            IconButton(
                onClick = {
                    //onClick.invoke()
                }
            ) {
                Image(
                    modifier = Modifier
                        .height(
                            dimensionResource(id = R.dimen.itinerary_img_size)
                        )
                        .width(
                            dimensionResource(id = R.dimen.itinerary_img_size)
                        ),
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "Delete"
                )
            }
        }
    }
}
