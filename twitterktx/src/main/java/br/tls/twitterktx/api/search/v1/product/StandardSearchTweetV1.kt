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

package br.tls.twitterktx.api.search.v1.product

import br.tls.twitterktx.api.search.factory.product.StandardSearchTweet
import br.tls.twitterktx.api.search.v1.model.Twitter

interface StandardSearchTweetV1: StandardSearchTweet {

    /**
     * Returns a collection of relevant Tweets matching a specified query.
     * @param query A UTF-8, URL-encoded search query of 500 characters maximum, including operators. Queries may additionally be limited by complexity.
     * @return twitter result
     */
    suspend fun searchTweet(query: String,  params: List<Pair<String, Any>>? = null): Twitter
}