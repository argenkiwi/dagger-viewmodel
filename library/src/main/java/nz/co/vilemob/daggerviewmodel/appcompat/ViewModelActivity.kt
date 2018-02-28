package nz.co.vilemob.daggerviewmodel.appcompat

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import nz.co.vilemob.daggerviewmodel.ViewModelFactory
import javax.inject.Inject

abstract class ViewModelActivity<VM : ViewModel> : AppCompatActivity() {

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
