## Test App
This is a small **Android application** written in **Kotlin** that:
* ask user to login (password and email is not empty) and if success
* fetches data from a service and displays it on the user interface using **Jetpack Compose**.

For more requirements look [here](https://github.com/thebeansgroup/StudentBeans_Android_Tech_Test).

Apk file is [here](https://github.com/astux7/StudentBeansTest/blob/main/apk).

## Design
<p float="left">
<img src="https://github.com/astux7/StudentBeansTest/blob/main/read_me_img/log_in.jpeg" alt="Log in" width="200">
<img src="https://github.com/astux7/StudentBeansTest/blob/main/read_me_img/password_error.jpeg" alt="Password error" width="200">
<img src="https://github.com/astux7/StudentBeansTest/blob/main/read_me_img/photo_list.jpeg" alt="List" width="200">
<img src="https://github.com/astux7/StudentBeansTest/blob/main/read_me_img/photo_list_error.jpeg" alt="Photo error" width="200">
</p>

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

## Testing
* Unit testing with JUnit4 - for repository and UseCase
* E2E testing - for UI of Jetpack Compose screens

## Improvements
* Caching with Retrofit cache or Room
* Improve UI design
* Add Pager