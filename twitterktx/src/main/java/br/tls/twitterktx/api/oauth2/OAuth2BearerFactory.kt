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

package br.tls.twitterktx.api.oauth2

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

internal class OAuth2BearerFactory constructor(private val context: Context) : Oauth2BearerAuth {

    private companion object {
        const val FILE_NAME = "encrypted_files"
        const val KEY_OAUTH = "oauth"
    }

    override var oauth2BearerToken: String
        get() {
            val invalidTokenValue = ""
            val keyValue = encryptedSharedPreferences.getString(KEY_OAUTH, invalidTokenValue)

            return keyValue
                ?: throw IllegalArgumentException("The oauth2 bearer token value does not exist")
        }
        set(value) {
            encryptedSharedPreferences.edit().putString(KEY_OAUTH, value).apply()
        }

    private val encryptedSharedPreferences: SharedPreferences
        get() {
            val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
            val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

            return EncryptedSharedPreferences
                .create(
                    FILE_NAME,
                    masterKeyAlias,
                    context,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                )
        }


}
