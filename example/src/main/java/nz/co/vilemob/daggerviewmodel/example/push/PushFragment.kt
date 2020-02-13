package nz.co.vilemob.daggerviewmodel.example.push

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
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
        scopedNumberTextView.text = getString(R.string.scoped_number, viewModel.scopedInt)
        unscopedNumberTextView.text = getString(R.string.unscoped_number, viewModel.unscopedInt)
    }
}
