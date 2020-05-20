/*
 * Copyright (c) 2020  Thiago Lopes da Silva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.tls.sample

import android.app.Application
import br.tls.sample.di.simpleModule
import br.tls.twitterktx.api.TwitterKtx
import br.tls.twitterktx.api.TwitterKtx.Companion.twitterKtxModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        configureKoin()
        configTimber()
    }

    private fun configureKoin() {
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@Application)
            modules(
                listOf(
                    simpleModule,
                    twitterKtxModule
                )
            )
        }
    }

    private fun configTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}