# dagger-viewmodel
A small library that combines dagger-android with the lifecycle-viewmodel library.

## Goals
- Remove the need to manually create factory classes for all your ViewModels
- Handle activity and fragment injection in a way that matches the lifecycle of dependent ViewModels
- Bind fragment injectors to the ViewModel lifecycle to reduce redundant injections and increase the predictability of scopes
