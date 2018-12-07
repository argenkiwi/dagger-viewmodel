package nz.co.vilemob.daggerviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class ViewModelActivity<VM : ViewModel> : FragmentActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        onViewModelCreated(onCreateViewModel(ViewModelProvider(this, viewModelFactory)))
    }

    protected abstract fun onCreateViewModel(viewModelProvider: ViewModelProvider): VM
    protected abstract fun onViewModelCreated(viewModel: VM)
}
