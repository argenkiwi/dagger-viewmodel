package nz.co.vilemob.daggerviewmodel.example.main

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import nz.co.vilemob.daggerviewmodel.example.ActivityScope
import nz.co.vilemob.daggerviewmodel.example.pop.PopFragment
import nz.co.vilemob.daggerviewmodel.example.push.PushFragment
import javax.inject.Named

@Module
abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun contributePushFragmentInjector(): PushFragment

    @ContributesAndroidInjector
    abstract fun contributePopFragmentInjector(): PopFragment

    @Binds
    @ActivityScope
    @Named("scoped_int")
    abstract fun scopedInt(number: Int): Int

    @Binds
    @Named("unscoped_int")
    abstract fun unscopedInt(number: Int): Int

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun number(): Int = (1..100).random()
    }
}
