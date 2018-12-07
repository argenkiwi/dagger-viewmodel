package nz.co.vilemob.daggerviewmodel.appcompat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import nz.co.vilemob.daggerviewmodel.ViewModelFactory
import javax.inject.Inject

abstract class ViewModelActivity<VM : ViewModel> : AppCompatActivity() {

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
