[![](https://jitpack.io/v/argenkiwi/dagger-viewmodel.svg)](https://jitpack.io/#argenkiwi/dagger-viewmodel)

# dagger-viewmodel
A small library that combines dagger-android with the lifecycle-viewmodel library.

## Goals
- Remove the need to manually create factory classes for all your ViewModels
- Handle activity and fragment injection in a way that matches the lifecycle of dependent ViewModels
- Bind fragment injectors to the ViewModel lifecycle to reduce redundant injections and increase the predictability of scopes

# Installation

If you haven't already, add JitPack's Maven repository to your project's `build.gradle` file:  
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Then add the following dependencies to your application's `build.gradle` file:
````groovy

ext {
    daggerVersion = '2.14.1'
}
    
dependencies {
    // Dagger
    implementation "com.google.dagger:dagger:$daggerVersion"
    kapt "com.google.dagger:dagger-compiler:$daggerVersion"
    
    // Dagger Android
    implementation "com.google.dagger:dagger-android:$daggerVersion"
    implementation "com.google.dagger:dagger-android-support:$daggerVersion"
    kapt "com.google.dagger:dagger-android-processor:$daggerVersion"
    
    // Architecture Lifecycle Extensions
    implementation "android.arch.lifecycle:extensions:1.1.0"
    
    // Dagger ViewModel
    implementation 'com.github.argenkiwi:dagger-viewmodel:v1.0.5'
}
````