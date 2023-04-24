## Demo App

This is a small **Android application** written in **Kotlin** that:
* ask user to login and if success
* fetches data from a service and displays it on the user interface using **Jetpack Compose**.

## Project structure

The project follows the MVVM architectural pattern
with clean architecture principles and includes an additional layer called 'UseCase'
that contains the business logic.

## Service
This app is fetching data from [Photo API](https://jsonplaceholder.typicode.com/photos ) service, which provides list of photo items.
The application makes API request:
* to retrieve all items `/photos`

## Libraries/ Technologies used:
* Retrofit - for network request
* Koin - for dependency injection (bonus library not necessary for this project to work)
* Jetpack compose - for UI
* Coil - for images
* Material - for UI usage