package nz.co.vilemob.daggerviewmodel

import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

abstract class DaggerViewModel : ViewModel() {

    @Inject
    internal lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    internal lateinit var frameworkFragmentInjector: DispatchingAndroidInjector<android.app.Fragment>
}
