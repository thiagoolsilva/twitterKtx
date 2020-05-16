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
import br.tls.twitterktx.api.search.standard.v1.api.StandartSearchTweetServiceImpl

class SearchTweetFactory : AbstractSearchTweetFactory {

    override fun createStandardApi(apiVersion: AbstractSearchTweetFactory.ApiVersion): StandardSearchTweet {
        when (apiVersion) {
            AbstractSearchTweetFactory.ApiVersion.V1_1 -> return StandartSearchTweetServiceImpl()
        }
    }

    override fun createPremiumApi(apiVersion: AbstractSearchTweetFactory.ApiVersion): PremiumSearchTweet {
        throw NotImplementedError("api not implemented")
    }

    override fun createEnterpriseApi(apiVersion: AbstractSearchTweetFactory.ApiVersion): EnterpriseSearchTweet {
        throw NotImplementedError("api not implemented")
    }


}