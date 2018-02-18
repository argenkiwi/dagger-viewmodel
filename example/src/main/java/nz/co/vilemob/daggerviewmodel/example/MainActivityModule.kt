package nz.co.vilemob.daggerviewmodel.example

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragmentInjector(): MainFragment
}