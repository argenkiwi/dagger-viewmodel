package nz.co.vilemob.daggerviewmodel.example

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nz.co.vilemob.daggerviewmodel.example.main.MainActivity
import nz.co.vilemob.daggerviewmodel.example.main.MainModule

@Module
abstract class ExampleApplicationModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeMainActivityInjector(): MainActivity
}
