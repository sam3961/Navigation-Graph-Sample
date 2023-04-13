**Whats in this project**
- This project contains five screens (Splash, Login, Signup, Home and Profile)
- This project use Navigation Component structure and shows how to navigate between two navigation graphs(From Auth to Home and Home to Auth) and usage of popupTo and inclusive in project.


**More Information about Navigation Component**
The “Navigation Component” simplifies implementing navigation, while also helping you visualize app’s navigation flow


**Why Promoting Navigation Component:**
- Automatic handling of fragment transactions
- Correctly handling up to and back by default.
- Default behaviours for animations and transitions
- Deep linking as a first-class operation.
- Implementing navigation UI patterns (like navigation drawers and bottom nav) with little additional work.
- Type safety when passing information while navigating.
- Android Studio tooling for visualizing and editing the navigation flow of an app


**Navigation Component:**
1. Navigation Graph (New XML resource) — This is a resource that contains all navigation-related information in one centralized location. This includes all the places in your app, known as destinations, and possible paths a user could take through your app.
2. NavHostFragment (Layout XML view) — This is a special widget you add to your layout. It displays different destinations from your Navigation Graph.
3. NavController (Kotlin/Java object) — This is an object that keeps track of the current position within the navigation graph. It orchestrates swapping destination content in the NavHostFragment as you move through a navigation graph.


## Usage

### Building the Navigation Graph Example App

First, clone the repo:

* git clone https://github.com/ezeep/ezp-printerapp-hp-workpath.git
* Building the Navigation Graph Example app then depends on your build tools.


### Android Studio

* Open Android Studio and select `File->Open...` or from the Android Launcher select `Import project (Eclipse ADT, Gradle, etc.)` and navigate to the root directory of your project.
* Select the directory or drill in and select the file `build.gradle` in the cloned repo.
* Click 'OK' to open the the project in Android Studio.
* A Gradle sync should start build the 'app' module as needed.


## Running the Navigation Graph Example App

Connect an Android device to your development machine.

### Android Studio

* Select `Run -> Run 'app'` (or `Debug 'app'`) from the menu bar
* Select the device you wish to run the app on and click 'OK'

### Gradle

* Install the debug APK on your device `./gradlew installDebug`
* Start the APK: `<path to Android SDK>/platform-tools/adb -d shell am start app.digiotouch.digivr.ui.component.MainActivity`

### Command Line

Assure you have a local.properties file in the top level directory with:
*sdk.dir=/path/to/your/Android/sdk*

Goto Shell/Terminal/, reach at android-sdk/tools directory then

adb install fileName.apk // (u can run this command on windows)
or
./adb install fileName.apk  //( u can run this command on linux)
