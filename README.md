# TimelineApp

Simple app for the best itinerary searching. There are two screens: for the itinerary searching and for the itinerary data. The first screen has to make network call to backend and get list of places (by string query). So using the search function user chooses departure point and destination point. After that he chooses date of journey and goes to the second screen. The second screen has to make another network call using departure point id, destination point id and the date. This request returns data about the best itinerary and displays information. This itinerary also will be saved in local database. I have no suitable API, thats why i created TempAppData in data layer. When we get network error we just replace backend data by TempAppData.

For this app i used:

- MVVM

- Room

- Retrofit

- Jetpack Compose

Demo:

<img width="260" alt="Снимок экрана 2022-04-03 в 16 04 29" src="https://user-images.githubusercontent.com/87421176/164480668-ce2ea446-fab5-48b7-abb2-ee0ed9d60a76.gif">
