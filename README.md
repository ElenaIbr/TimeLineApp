# TimeLineApp

This is the simple app for the best itinerary searching. There are two screens: for itinerary searching and for itinerary data. The first screen has to make network call to backend and get list of places (by string quaery). So using the search user chooses departue point and destination point. After that he chooses date of journery and goes to the second screen. The second screen has to make another one network call using departue point id, destination point id and the date. This request returns data about the best itinerary and dispays information. This itinerary also will be saved in local db. I have no sutable API, thats why i created TempAppData in data layer. When we get network error we replace backend data by TempAppData.
For this app i used:

MVVM
Room
Retrofit
Jetpack Compose

Demo:

![164479386-b46b46b3-f6e9-4eb4-80aa-69cd2d276681](https://user-images.githubusercontent.com/87421176/164480668-ce2ea446-fab5-48b7-abb2-ee0ed9d60a76.gif)
