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

package br.tls.twitterktx.api.search.v1

import br.tls.twitterktx.BuildConfig
import br.tls.twitterktx.api.oauth2.Oauth2BearerAuth
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder constructor(val oAuth2BearerAuth: Oauth2BearerAuth) {

    internal val retrofitClient = Retrofit.Builder()
        .baseUrl(BuildConfig.TWITTER_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(configInterceptor())
        .build()

    /**
     * Config interceptor
     */
    private fun configInterceptor(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor {
            val original = it.request()
            val request = original.newBuilder()
                .header("Authorization", "Bearer ".plus(oAuth2BearerAuth.oauth2BearerToken))
                .header("Content-Type", "application/json")
                .method(original.method(), original.body())
                .build()
            it.proceed(request)
        }

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()

            logging.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logging)
        }

        return httpClient.build()
    }
}
