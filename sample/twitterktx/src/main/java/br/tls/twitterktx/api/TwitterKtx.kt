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

import br.tls.twitterktx.api.oauth2.OAuth2BearerFactory
import br.tls.twitterktx.api.oauth2.Oauth2BearerAuth
import org.koin.core.module.Module
import org.koin.java.KoinJavaComponent.inject

class TwitterKtx {

    private val oauth2BearerAuth: Oauth2BearerAuth by inject(OAuth2BearerFactory::class.java)

    companion object {

        /**
         * Get a instance of twitter Ktx module to be used on Koin configuration
         */
        val twitterKtxModule: Module
            get() {
                return br.tls.twitterktx.api.di.twitterKtxModule
            }

    }

    /**
     * Config oauth2 bearer token
     * @param token token
     */
    fun configToken(token: String) {
        oauth2BearerAuth.oauth2BearerToken = token
    }

}