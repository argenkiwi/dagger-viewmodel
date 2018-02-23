package nz.co.vilemob.daggerviewmodel.example.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import nz.co.vilemob.daggerviewmodel.example.ActivityScope
import nz.co.vilemob.daggerviewmodel.example.pop.PopFragment
import nz.co.vilemob.daggerviewmodel.example.push.PushFragment
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun contributePushFragmentInjector(): PushFragment

    @ContributesAndroidInjector
    abstract fun contributePopFragmentInjector(): PopFragment

    @Binds
    @ActivityScope
    @Named("scoped_live_data")
    abstract fun scopedLiveData(intLiveData: LiveData<Int>): LiveData<Int>

    @Binds
    @Named("unscoped_live_data")
    abstract fun unscopedLiveData(intLiveData: LiveData<Int>): LiveData<Int>

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun intervalObservable(): Observable<Int> = Observable
                .interval(1, TimeUnit.SECONDS)
                .scan(0, { previous, _ -> previous + 1 })

        @JvmStatic
        @Provides
        fun intervalLiveData(observable: Observable<Int>): LiveData<Int> {
            val timerMutableLiveData = MutableLiveData<Int>()
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { timerMutableLiveData.value = it }
            return timerMutableLiveData
        }
    }
}