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

package br.tls.twitterktx.api.search.factory

import br.tls.twitterktx.api.search.factory.product.EnterpriseSearchTweet
import br.tls.twitterktx.api.search.factory.product.PremiumSearchTweet
import br.tls.twitterktx.api.search.factory.product.StandardSearchTweet

interface AbstractSearchTweetFactory {

    enum class ApiVersion {
        V1_1
    }

    /**
     * Create the standard search tweet API
     * @param apiVersion api version
     * @return a concrete search tweet implementation
     */
    fun createStandardApi(apiVersion: ApiVersion): StandardSearchTweet

    /**
     * Create the premium search tweet API
     * @param apiVersion api version
     * @return a concrete search tweet implementation
     */
    fun createPremiumApi(apiVersion: ApiVersion): PremiumSearchTweet

    /**
     * Create the enterprise search tweet API
     * @param apiVersion api version
     * @return a concrete search tweet implementation
     */
    fun createEnterpriseApi(apiVersion: ApiVersion): EnterpriseSearchTweet

}