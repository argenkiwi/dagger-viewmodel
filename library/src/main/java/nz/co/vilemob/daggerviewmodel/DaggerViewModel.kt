package nz.co.vilemob.daggerviewmodel

import androidx.lifecycle.ViewModel
import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

abstract class DaggerViewModel : ViewModel() {

    @Inject
    internal lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>
}
