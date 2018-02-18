package nz.co.vilemob.daggerviewmodel.example

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ExampleApplicationModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivityInjector(): MainActivity
}