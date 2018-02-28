package nz.co.vilemob.daggerviewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by Leandro on 17/02/2018.
 */
abstract class ViewModelActivity<VM : ViewModel> : FragmentActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        ViewModelProvider(this, viewModelFactory)
                .let { viewModelProvider -> onCreateViewModel(viewModelProvider) }
                .let { viewModel -> onViewModelCreated(viewModel) }
    }

    protected abstract fun onCreateViewModel(viewModelProvider: ViewModelProvider): VM
    protected abstract fun onViewModelCreated(viewModel: VM)
}