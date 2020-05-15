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

package br.tls.twitterktx.api

import br.tls.twitterktx.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {

    private fun configLogging(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()

        logging.level = HttpLoggingInterceptor.Level.HEADERS
        httpClient.addInterceptor(logging)

        return httpClient.build()
    }

    private val retrofitClient = Retrofit.Builder()
        .baseUrl(BuildConfig.TWITTER_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(configLogging())
        .build()

    // need to be refactory
    val clientService =  retrofitClient.create(ApiTwitterService::class.java)

}