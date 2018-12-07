package nz.co.vilemob.daggerviewmodel.example.push

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import nz.co.vilemob.daggerviewmodel.ViewModelFragment
import nz.co.vilemob.daggerviewmodel.example.R
import nz.co.vilemob.daggerviewmodel.example.pop.PopFragment

class PushFragment : ViewModelFragment<PushViewModel>() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pushFragmentButton.setOnClickListener {
            fragmentManager?.apply {
                beginTransaction()
                        .replace(android.R.id.content, PopFragment())
                        .addToBackStack("PUSH")
                        .commit()
            }
        }
    }

    override fun onCreateViewModel(viewModelProvider: ViewModelProvider) =
            viewModelProvider.get(PushViewModel::class.java)

    override fun onViewModelCreated(viewModel: PushViewModel) {
        viewModel.scopedLiveData.observe(this, Observer {
            scopedTimerTextView.text = getString(R.string.scoped_timer, it)
        })

        viewModel.unscopedLiveData.observe(this, Observer {
            unscopedTimerTextView.text = getString(R.string.unscoped_timer, it)
        })
    }
}
