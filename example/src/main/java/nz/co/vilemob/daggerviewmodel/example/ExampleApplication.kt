package nz.co.vilemob.daggerviewmodel.example

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class ExampleApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerExampleApplicationComponent.builder().create(this)
}
