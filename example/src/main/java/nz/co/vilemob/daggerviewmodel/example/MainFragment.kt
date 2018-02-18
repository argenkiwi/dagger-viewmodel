package nz.co.vilemob.daggerviewmodel.example

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nz.co.vilemob.daggerviewmodel.ViewModelFragment

class MainFragment : ViewModelFragment<MainFragmentViewModel>() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onCreateViewModel(viewModelProvider: ViewModelProvider) =
            viewModelProvider.get(MainFragmentViewModel::class.java)

    override fun onViewModelCreated(viewModel: MainFragmentViewModel) {
        // TODO initialise or get reference to viewModel here.
    }
}
