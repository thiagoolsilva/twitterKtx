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

import br.tls.twitterktx.api.search.factory.product.StandardSearchTweet
import br.tls.twitterktx.api.search.standard.v1.StandartSearchTweetClient.searchTweetClient
import br.tls.twitterktx.api.search.standard.v1.model.Twitter

/**
 * Implement the standard API Search tweet.
 * For more details about it go to https://developer.twitter.com/en/docs/tweets/search/api-reference/get-search-tweets
 */
class StandartSearchTweetServiceImpl :
    StandardSearchTweet {

    companion object PARAMETERS {

        /**
         * Returns tweets by users located within a given radius of the given latitude/longitude.
         * The location is preferentially taking from the Geotagging API, but will fall back to their Twitter profile.
         * The parameter value is specified by " latitude,longitude,radius ",
         * where radius units must be specified as either " mi " (miles) or " km " (kilometers).
         * Note that you cannot use the near operator via the API to geocode arbitrary locations;
         * however you can use this geocode parameter to search near geocodes directly.
         * A maximum of 1,000 distinct "sub-regions" will be considered when using the radius modifier.
         *
         * Ex: 37.781157 or -122.3987201 or mi or km
         */
        val GEOCODE = "geocode"


        /**
         * Restricts tweets to the given language, given by an ISO 639-1 code. Language detection is best-effort.
         *
         * Ex: eu
         */
        val LANG = "lang"

        /**
         * Specify the language of the query you are sending (only ja is currently effective).
         * This is intended for language-specific consumers and the default should work in the majority of cases.
         *
         * Ex: ja
         */
        val LOCALE = "locale"

        /**
         * Optional. Specifies what type of search results you would prefer to receive. The current default is "mixed." Valid values include:
         * mixed : Include both popular and real time results in the response.
         * recent : return only the most recent results in the response
         * popular : return only the most popular results in the response.
         *
         * Ex; mixed or recent or popular
         */
        val RESULT_TYPE = "result_type"

        /**
         * The number of tweets to return per page, up to a maximum of 100.
         * Defaults to 15. This was formerly the "rpp" parameter in the old Search API.
         *
         * Ex; 100
         */
        val COUNT = "count"

        /**
         * Returns tweets created before the given date. Date should be formatted as YYYY-MM-DD.
         * Keep in mind that the search index has a 7-day limit. In other words, no tweets will be found for a date older than one week.
         *
         * Ex: 2015-07-19
         */
        val UNTIL = "until"

        /**
         * Returns results with an ID greater than (that is, more recent than) the specified ID. There are limits to the number of Tweets which can be accessed through the API.
         * If the limit of Tweets has occured since the since_id, the since_id will be forced to the oldest ID available.
         *
         * Ex:12345
         */
        val SINCE_ID = "since_id"

        /**
         * Returns results with an ID less than (that is, older than) or equal to the specified ID.
         *
         * Ex: 54321
         */
        val MAX_ID = "max_id"

        /**
         * The entities node will not be included when set to false.
         *
         * Ex: false
         */
        val INCLUDE_ENTITIES = "include_entities"
    }

    override suspend fun searchTweet(query: String, params: List<Pair<String, String>>?): Twitter {
        if (validateParams(params)) {
            val twitterService = searchTweetClient
            // use the parameters
            // TBD
            return twitterService.searchTwitters(query = query)
        } else {
            throw IllegalArgumentException("It was provided invalid parameters.")
        }
    }

    /**
     * Check if was provided valid parameters
     * @param params optional api parameters
     * @return true if all optional parameters are valid
     */
    private fun validateParams(params: List<Pair<String, String>>?): Boolean {
        var isValid = false

        params?.let {
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
                it.second.isNotEmpty() &&
                        validParameters.contains(it.second)
            }

            isValid = rest.isEmpty()
        } ?: apply {
            isValid = true
        }

        return isValid
    }

}