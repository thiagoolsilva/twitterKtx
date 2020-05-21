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

package br.tls.twitterktx.api.search.v1.standard.client

import br.tls.twitterktx.api.search.v1.RetrofitBuilder
import br.tls.twitterktx.api.search.v1.standard.api.StandardSearchTweetV1Api

class StandardSearchTweetClient(val retrofitBuilder: RetrofitBuilder) {

    internal val SEARCH_TWEET_V_1_API_CLIENT: StandardSearchTweetV1Api =
        retrofitBuilder.retrofitClient.create(StandardSearchTweetV1Api::class.java)

}