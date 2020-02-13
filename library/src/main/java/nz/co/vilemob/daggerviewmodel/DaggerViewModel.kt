package nz.co.vilemob.daggerviewmodel

import androidx.lifecycle.ViewModel
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

abstract class DaggerViewModel : ViewModel() {

    @Inject
    internal lateinit var androidInjector: DispatchingAndroidInjector<Any>
}
