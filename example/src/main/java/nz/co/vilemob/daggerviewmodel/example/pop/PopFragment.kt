package nz.co.vilemob.daggerviewmodel.example.pop

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import nz.co.vilemob.daggerviewmodel.ViewModelFragment
import nz.co.vilemob.daggerviewmodel.example.R

class PopFragment : ViewModelFragment<PopViewModel>() {

    private lateinit var scopedTimerTextView: TextView
    private lateinit var unscopedTimerTextView: TextView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_pop, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scopedTimerTextView = view.findViewById(R.id.scoped_timer)
        unscopedTimerTextView = view.findViewById(R.id.unscoped_timer)
    }

    override fun onCreateViewModel(viewModelProvider: ViewModelProvider) =
            viewModelProvider.get(PopViewModel::class.java)

    override fun onViewModelCreated(viewModel: PopViewModel) {
        viewModel.scopedLiveData.observe(this, Observer {
            scopedTimerTextView.text = getString(R.string.scoped_timer, it)
        })

        viewModel.unscopedLiveData.observe(this, Observer {
            unscopedTimerTextView.text = getString(R.string.unscoped_timer, it)
        })
    }
}
