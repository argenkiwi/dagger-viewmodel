package nz.co.vilemob.daggerviewmodel

import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector

abstract class DaggerViewModelActivity<VM : DaggerViewModel> : ViewModelActivity<VM>(),
        HasFragmentInjector, HasSupportFragmentInjector {

    private lateinit var viewModel: VM

    override fun onViewModelCreated(viewModel: VM) {
        this.viewModel = viewModel
    }

    override fun fragmentInjector() = viewModel.frameworkFragmentInjector
    override fun supportFragmentInjector() = viewModel.supportFragmentInjector
}
