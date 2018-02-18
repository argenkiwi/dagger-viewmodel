package nz.co.vilemob.daggerviewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Lazy
import javax.inject.Inject

/**
 * Created by Leandro on 16/02/2018.
 */
class ViewModelFactory<T : ViewModel> @Inject constructor(
        private val viewModel: Lazy<T>
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = viewModel.get() as T
}