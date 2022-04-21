package com.example.timelineapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.timelineapp.ui.itinerary.ItineraryScreen
import com.example.timelineapp.ui.itinerarysearch.ItinerarySearchSearch
import com.example.timelineapp.ui.theme.TimeLineAppTheme
import com.example.timelineapp.utilits.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeLineAppTheme {
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //ItineraryScreen()
                    ItinerarySearchSearch()
                }*/


                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.ITINERARY_SEARCH
                ) {
                    composable(Routes.ITINERARY_SEARCH) {
                        ItinerarySearchSearch(
                            navController = navController
                        )
                    }
                    composable(
                        route = Routes.ITINERARY + "?departureId={departureId}" + "?destinationId={destinationId}" + "?date={date}",
                        arguments = listOf(
                            navArgument(name = "departureId") {
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument(name = "destinationId") {
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument(name = "date") {
                                type = NavType.StringType
                                defaultValue = ""
                            }

                        )
                    ) {
                        ItineraryScreen(OnBackStack = {
                            navController.popBackStack()
                        })
                    }
                }
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //ItineraryScreen()
                    //ItinerarySearchSearch()
                }*/
            }
        }
    }
}
