package nz.co.vilemob.daggerviewmodel.example.pop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_pop.*
import nz.co.vilemob.daggerviewmodel.ViewModelFragment
import nz.co.vilemob.daggerviewmodel.example.R

class PopFragment : ViewModelFragment<PopViewModel>() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_pop, container, false)

    override fun onCreateViewModel(viewModelProvider: ViewModelProvider) =
            viewModelProvider.get(PopViewModel::class.java)

    override fun onViewModelCreated(viewModel: PopViewModel) {
        scopedNumberTextView.text = getString(R.string.scoped_number, viewModel.scopedInt)
        unscopedNumberTextView.text = getString(R.string.unscoped_number, viewModel.unscopedInt)
    }
}
