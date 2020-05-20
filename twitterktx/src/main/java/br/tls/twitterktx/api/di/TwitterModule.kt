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

package br.tls.twitterktx.api.di

import br.tls.twitterktx.api.RetrofitBuilder
import br.tls.twitterktx.api.TwitterKtx
import br.tls.twitterktx.api.oauth2.OAuth2BearerFactory
import br.tls.twitterktx.api.oauth2.Oauth2BearerAuth
import br.tls.twitterktx.api.search.v1.standard.StandardSearchTweetClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.dsl.bind
import org.koin.dsl.koinApplication
import org.koin.dsl.module

internal val twitterKtxKoinModule = koinApplication {
    // declare used modules
    modules(twitterKtxModule)
}

internal val twitterKtxModule = module {

    single {
        OAuth2BearerFactory(context = androidContext())
    } bind Oauth2BearerAuth::class

    single {
        RetrofitBuilder(oAuth2BearerAuth = get())
    }

    single {
        StandardSearchTweetClient(retrofitBuilder = get())
    }

    single {
        TwitterKtx()
    }

}
