package nz.co.vilemob.daggerviewmodel.example

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragmentInjector(): MainFragment

    @Module
    companion object {

        @JvmStatic
        @Provides
        @ActivityScope
        @Named("scoped_observable")
        fun scopedObservable(): Observable<Int> = Observable
                .interval(1, TimeUnit.SECONDS)
                .scan(0, { previous, _ -> previous + 1 })

        @JvmStatic
        @Provides
        @Named("unscoped_observable")
        fun unscopedObservable(): Observable<Int> = Observable
                .interval(1, TimeUnit.SECONDS)
                .scan(0, { previous, _ -> previous + 1 })
    }
}