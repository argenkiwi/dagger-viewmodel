package nz.co.vilemob.daggerviewmodel.example

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Leandro on 18/02/2018.
 */
class MainFragmentViewModel @Inject constructor(
        @Named("scoped_observable") scopedObservable: Observable<Int>,
        @Named("unscoped_observable") unscopedObservable: Observable<Int>
) : ViewModel() {
    val scopedTimerLiveData = Companion.initTimerLiveData(scopedObservable)
    val unscopedTimerLiveData = Companion.initTimerLiveData(unscopedObservable)

    companion object {

        @JvmStatic
        private fun initTimerLiveData(observable: Observable<Int>): LiveData<Int> {
            val timerMutableLiveData = MutableLiveData<Int>()
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { timerMutableLiveData.value = it }
            return timerMutableLiveData
        }
    }
}