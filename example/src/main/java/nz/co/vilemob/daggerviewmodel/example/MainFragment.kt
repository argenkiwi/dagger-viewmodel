package nz.co.vilemob.daggerviewmodel.example

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import nz.co.vilemob.daggerviewmodel.ViewModelFragment

class MainFragment : ViewModelFragment<MainFragmentViewModel>() {

    private lateinit var scopedTimerTextView: TextView
    private lateinit var unscopedTimerTextView: TextView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scopedTimerTextView = view.findViewById(R.id.scoped_timer)
        unscopedTimerTextView = view.findViewById(R.id.unscoped_timer)
    }

    override fun onCreateViewModel(viewModelProvider: ViewModelProvider) =
            viewModelProvider.get(MainFragmentViewModel::class.java)

    override fun onViewModelCreated(viewModel: MainFragmentViewModel) {
        viewModel.scopedTimerLiveData.observe(this, Observer {
            scopedTimerTextView.text = getString(R.string.scoped_timer, it)
        })

        viewModel.unscopedTimerLiveData.observe(this, Observer {
            unscopedTimerTextView.text = getString(R.string.unscoped_timer, it)
        })
    }
}
