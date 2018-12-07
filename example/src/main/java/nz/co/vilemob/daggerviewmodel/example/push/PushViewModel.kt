package nz.co.vilemob.daggerviewmodel.example.push

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Leandro on 18/02/2018.
 */
class PushViewModel @Inject constructor(
        @Named("scoped_live_data") val scopedLiveData: LiveData<Int>,
        @Named("unscoped_live_data") val unscopedLiveData: LiveData<Int>
) : ViewModel()
