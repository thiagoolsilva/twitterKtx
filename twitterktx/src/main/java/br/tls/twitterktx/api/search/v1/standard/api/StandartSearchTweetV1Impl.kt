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

package br.tls.twitterktx.api.search.v1.standard.api

import br.tls.twitterktx.api.search.model.Twitter
import br.tls.twitterktx.api.search.v1.standard.api.StandardSearchTweetV1Api.PARAMETERS.COUNT
import br.tls.twitterktx.api.search.v1.standard.api.StandardSearchTweetV1Api.PARAMETERS.GEOCODE
import br.tls.twitterktx.api.search.v1.standard.api.StandardSearchTweetV1Api.PARAMETERS.INCLUDE_ENTITIES
import br.tls.twitterktx.api.search.v1.standard.api.StandardSearchTweetV1Api.PARAMETERS.LANG
import br.tls.twitterktx.api.search.v1.standard.api.StandardSearchTweetV1Api.PARAMETERS.LOCALE
import br.tls.twitterktx.api.search.v1.standard.api.StandardSearchTweetV1Api.PARAMETERS.MAX_ID
import br.tls.twitterktx.api.search.v1.standard.api.StandardSearchTweetV1Api.PARAMETERS.RESULT_TYPE
import br.tls.twitterktx.api.search.v1.standard.api.StandardSearchTweetV1Api.PARAMETERS.SINCE_ID
import br.tls.twitterktx.api.search.v1.standard.api.StandardSearchTweetV1Api.PARAMETERS.UNTIL
import br.tls.twitterktx.api.search.v1.product.StandardSearchTweetV1
import br.tls.twitterktx.api.search.v1.standard.client.StandardSearchTweetClient
import org.koin.java.KoinJavaComponent.inject

/**
 * Implement tbr.tls.sample.utilhe standard API Search tweet.
 * For more details about it go to https://developer.twitter.com/en/docs/tweets/search/api-reference/get-search-tweets
 */
internal class StandartSearchTweetV1Impl :
    StandardSearchTweetV1 {

    val standardSearchTweetClient by inject(StandardSearchTweetClient::class.java)

    override suspend fun searchTweet(query: String, params: List<Pair<String, Any>>?): Twitter {
        if (validateParams(params)) {
            val twitterService = standardSearchTweetClient.SEARCH_TWEET_V_1_API_CLIENT
            val queryMap = mutableMapOf<String, Any>()
            params?.let {
                it.forEach {
                    queryMap.put(it.first, it.second)
                }
                queryMap
            }

            return twitterService.searchTwitters(query = query, optionalParameter = queryMap)
        } else {
            throw IllegalArgumentException("It was provided invalid parameters.")
        }
    }

    /**
     * Check if was provided valid parameters
     * @param params optional api parameters
     * @return true if all optional parameters are valid
     */
    private fun validateParams(params: List<Pair<String, Any>>?): Boolean {
        return params?.let {
            val validParameters = arrayOf(
                GEOCODE,
                LANG,
                LOCALE,
                RESULT_TYPE,
                COUNT,
                UNTIL,
                SINCE_ID,
                MAX_ID,
                INCLUDE_ENTITIES
            )

            val (_, rest) = params.partition {
                it.first.isNotEmpty() && validParameters.contains(it.first)
            }

            rest.isEmpty()
        } ?: kotlin.run {
            false
        }
    }

}