package nz.co.vilemob.daggerviewmodel

import dagger.android.support.HasSupportFragmentInjector

abstract class DaggerViewModelFragment<VM : DaggerViewModel> : ViewModelFragment<VM>(),
        HasSupportFragmentInjector {

    private lateinit var viewModel: VM

    override fun onViewModelCreated(viewModel: VM) {
        this.viewModel = viewModel
    }

    override fun supportFragmentInjector() = viewModel.supportFragmentInjector
}
