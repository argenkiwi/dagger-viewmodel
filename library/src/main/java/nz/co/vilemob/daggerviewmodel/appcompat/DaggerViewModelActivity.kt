package nz.co.vilemob.daggerviewmodel.appcompat

import dagger.android.support.HasSupportFragmentInjector
import nz.co.vilemob.daggerviewmodel.DaggerViewModel

abstract class DaggerViewModelActivity<VM : DaggerViewModel> : ViewModelActivity<VM>(),
        HasSupportFragmentInjector {

    private lateinit var viewModel: VM

    override fun onViewModelCreated(viewModel: VM) {
        this.viewModel = viewModel
    }

    override fun supportFragmentInjector() = viewModel.supportFragmentInjector
}
