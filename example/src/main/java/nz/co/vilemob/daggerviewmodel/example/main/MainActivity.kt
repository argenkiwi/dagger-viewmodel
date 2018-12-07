package nz.co.vilemob.daggerviewmodel.example.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import nz.co.vilemob.daggerviewmodel.appcompat.DaggerViewModelActivity
import nz.co.vilemob.daggerviewmodel.example.push.PushFragment

class MainActivity : DaggerViewModelActivity<MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (savedInstanceState) {
            null -> supportFragmentManager.beginTransaction()
                    .add(android.R.id.content, PushFragment())
                    .commit()
        }
    }

    override fun onCreateViewModel(viewModelProvider: ViewModelProvider) =
            viewModelProvider.get(MainViewModel::class.java)
}
