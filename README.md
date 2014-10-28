BCL-android-studio-samples
=========================

These sample apps were created with the Brightcove Player SDK for Android, using Android Studio. 

## Installing the sample apps

To install the sample apps into Android Studio follow these steps:

1. Obtain and install the latest version of Android Studio using the provided on-line instructions.
2. Click the Download Zip button in the bottom-right of the GitHub page.
3. Unzip the file.
4. Open Android Studio.
5. Select **File > Open**.
6. Choose the folder for the sample project that you want to run.

Android Studio will now open and build the sample app. At this point the sample will be in your instance of Android Studio where you can observe the snippets in action on a physical or virtual device, walk through the code using the Android Studio debugger, search on keywords or just browse Android source code.

## Overriding the default build behavior

By default, the sample apps will build with the most recent Brightcove Android Native Player version at build time. To override this behavior with a specific version, create a file named .gradle/gradle.properties in your home directory and set the value of the property anpVersion to the desired version. An invalid version will cause no sample app projects to be configured.

## Running a sample app

To run a sample app on an Android 4.2.2 or later device, plug the device into the computer and ensure that USB debugging is enabled. Android Studio will recognize the device as long as the device identifies as running a version between Android 10 and Android 19 otherwise Android Studio will run the sample app in the simulator. Using the simulator is not recommended as video support is buggy. This will be resolved as Android Studio and the Android SDK mature.

  Select the run (green button) icon to start the sample.

