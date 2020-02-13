package nz.co.vilemob.daggerviewmodel.appcompat

import dagger.android.HasAndroidInjector
import nz.co.vilemob.daggerviewmodel.DaggerViewModel

abstract class DaggerViewModelActivity<VM : DaggerViewModel> : ViewModelActivity<VM>(),
        HasAndroidInjector {

    private lateinit var viewModel: VM

    override fun onViewModelCreated(viewModel: VM) {
        this.viewModel = viewModel
    }

    override fun androidInjector() = viewModel.androidInjector
}
