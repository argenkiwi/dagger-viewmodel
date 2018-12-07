package nz.co.vilemob.daggerviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class ViewModelFragment<VM : ViewModel> : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory<VM>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        onViewModelCreated(onCreateViewModel(ViewModelProvider(this, viewModelFactory)))
    }

    protected abstract fun onCreateViewModel(viewModelProvider: ViewModelProvider): VM
    protected abstract fun onViewModelCreated(viewModel: VM)
}
