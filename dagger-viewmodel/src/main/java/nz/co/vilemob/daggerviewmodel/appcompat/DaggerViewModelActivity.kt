package nz.co.vilemob.daggerviewmodel.appcompat

import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import nz.co.vilemob.daggerviewmodel.DaggerViewModel

/**
 * Created by Leandro on 17/02/2018.
 */
abstract class DaggerViewModelActivity<VM : DaggerViewModel> : ViewModelActivity<VM>(),
        HasFragmentInjector, HasSupportFragmentInjector {

    private lateinit var viewModel: VM

    override fun onViewModelCreated(viewModel: VM) {
        this.viewModel = viewModel
    }

    override fun fragmentInjector() = viewModel.frameworkFragmentInjector
    override fun supportFragmentInjector() = viewModel.supportFragmentInjector
}
