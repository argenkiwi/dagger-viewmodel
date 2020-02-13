package nz.co.vilemob.daggerviewmodel

import dagger.android.HasAndroidInjector

abstract class DaggerViewModelFragment<VM : DaggerViewModel> : ViewModelFragment<VM>(),
        HasAndroidInjector {

    private lateinit var viewModel: VM

    override fun onViewModelCreated(viewModel: VM) {
        this.viewModel = viewModel
    }

    override fun androidInjector() = viewModel.androidInjector
}
