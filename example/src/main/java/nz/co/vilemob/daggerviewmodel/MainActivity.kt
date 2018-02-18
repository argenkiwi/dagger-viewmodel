package nz.co.vilemob.daggerviewmodel

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import nz.co.vilemob.daggerviewmodel.appcompat.DaggerViewModelActivity

class MainActivity : DaggerViewModelActivity<MainActivityViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateViewModel(
            viewModelProvider: ViewModelProvider
    ) = viewModelProvider.get(MainActivityViewModel::class.java)

    override fun onViewModelCreated(viewModel: MainActivityViewModel) {
        super.onViewModelCreated(viewModel)
        // TODO Your activity view model initialisation code here.
    }
}
