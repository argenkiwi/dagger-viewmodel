package nz.co.vilemob.daggerviewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class ViewModelFragment<VM : ViewModel> : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory<VM>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        ViewModelProviders.of(this, viewModelFactory)
                .let { viewModelProvider -> onCreateViewModel(viewModelProvider) }
                .let { viewModel -> onViewModelCreated(viewModel) }
    }

    protected abstract fun onCreateViewModel(viewModelProvider: ViewModelProvider): VM
    protected abstract fun onViewModelCreated(viewModel: VM)
}