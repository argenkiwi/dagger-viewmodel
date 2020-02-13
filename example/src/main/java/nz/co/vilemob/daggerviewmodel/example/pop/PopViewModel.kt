package nz.co.vilemob.daggerviewmodel.example.pop

import androidx.lifecycle.ViewModel
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Leandro on 20/02/2018.
 */
class PopViewModel @Inject constructor(
        @Named("scoped_int") val scopedInt: Int,
        @Named("unscoped_int") val unscopedInt: Int
) : ViewModel()
