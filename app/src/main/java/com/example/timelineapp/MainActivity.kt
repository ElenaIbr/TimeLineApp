package com.example.timelineapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.timelineapp.ui.bestitinerary.ItineraryScreen
import com.example.timelineapp.ui.bestitinerarysearch.ItinerarySearchSearch
import com.example.timelineapp.ui.theme.TimeLineAppTheme
import com.example.timelineapp.utilits.Constants
import com.example.timelineapp.utilits.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeLineAppTheme {
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
                        route = Routes.ITINERARY
                                + "?${Constants.DEPARTURE_ID}={${Constants.DEPARTURE_ID}}"
                                + "?${Constants.DESTINATION_ID}={${Constants.DESTINATION_ID}}"
                                + "?${Constants.ITINERARY_DATE}={${Constants.ITINERARY_DATE}}"
                                + "?${Constants.ITINERARY_ID}={${Constants.ITINERARY_ID}}"
                                + "?${Constants.IS_NEW_ITINERARY}={${Constants.IS_NEW_ITINERARY}}",
                        arguments = listOf(
                            navArgument(name = Constants.DEPARTURE_ID) {
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument(name = Constants.DESTINATION_ID) {
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument(name = Constants.ITINERARY_DATE) {
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument(name = Constants.ITINERARY_ID) {
                                type = NavType.IntType
                                defaultValue = -1
                            },
                            navArgument(name = Constants.IS_NEW_ITINERARY) {
                                type = NavType.BoolType
                                defaultValue = true
                            }
                        )
                    ) {
                        ItineraryScreen(
                            onBackStack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}
