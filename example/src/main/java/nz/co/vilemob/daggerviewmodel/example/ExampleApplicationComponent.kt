package nz.co.vilemob.daggerviewmodel.example

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    ExampleApplicationModule::class
])
internal interface ExampleApplicationComponent : AndroidInjector<ExampleApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ExampleApplication>()
}