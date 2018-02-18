package nz.co.vilemob.daggerviewmodel.example

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import nz.co.vilemob.daggerviewmodel.appcompat.DaggerViewModelActivity

class MainActivity : DaggerViewModelActivity<MainActivityViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (savedInstanceState) {
            null -> supportFragmentManager.beginTransaction()
                    .add(android.R.id.content, MainFragment())
                    .commit()
        }
    }

    override fun onCreateViewModel(viewModelProvider: ViewModelProvider) =
            viewModelProvider.get(MainActivityViewModel::class.java)

    override fun onViewModelCreated(viewModel: MainActivityViewModel) {
        super.onViewModelCreated(viewModel)
        // TODO initialise or get reference to viewModel here.
    }
}
