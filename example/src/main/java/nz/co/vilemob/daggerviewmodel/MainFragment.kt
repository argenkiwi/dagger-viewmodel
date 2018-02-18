package nz.co.vilemob.daggerviewmodel


import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : ViewModelFragment<MainFragmentViewModel>() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onCreateViewModel(
            viewModelProvider: ViewModelProvider
    ) = viewModelProvider.get(MainFragmentViewModel::class.java)

    override fun onViewModelCreated(viewModel: MainFragmentViewModel) {
        // TODO Your fragment view model initialisation code here.
    }
}
