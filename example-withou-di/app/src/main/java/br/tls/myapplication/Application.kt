package br.tls.myapplication

import android.app.Application
import br.tls.twitterktx.BuildConfig
import br.tls.twitterktx.api.TwitterKtx
import timber.log.Timber

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        configTwitterKtx()
        configTimber()
    }

    private fun configTwitterKtx() {
        TwitterKtx.init(this@Application)
    }

    private fun configTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}