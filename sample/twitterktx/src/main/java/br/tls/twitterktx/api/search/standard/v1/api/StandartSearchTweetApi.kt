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

package br.tls.twitterktx.api.search.standard.v1.api

import br.tls.twitterktx.api.search.standard.v1.model.Twitter
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface StandartSearchTweetApi {

    @Headers("Authorization:Bearer AAAAAAAAAAAAAAAAAAAAAIwgeAAAAAAAbIa2AfSgnm7JS60iaBTCIAiLXYo%3DvsbsOmA108kFII3HUNLOgyKlCBQbO216nSpLiFKaCVN6XxFRV2")
    @GET("/1.1/search/tweets.json")
    suspend fun searchTwitters(@Query("q") query: String): Twitter

}