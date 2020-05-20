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

package br.tls.sample.mainsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.tls.sample.model.ResultState
import br.tls.twitterktx.api.search.factory.SearchTweetFactory
import br.tls.twitterktx.api.search.v1.model.Twitter
import br.tls.twitterktx.api.search.v1.product.StandardSearchTweetV1
import br.tls.twitterktx.api.search.v1.standard.api.StandartSearchTweetV1Api
import kotlinx.coroutines.launch

class FirstViewModel :
    ViewModel() {

    private val _tweetState = MutableLiveData<ResultState<Twitter>>()
    val tweetState: LiveData<ResultState<Twitter>>
        get() = _tweetState

    fun searchTrendTweet(query: String) {
        viewModelScope.launch {
            try {
                val standardSearchTweet =
                    SearchTweetFactory().createStandardApi<StandardSearchTweetV1>(
                        SearchTweetFactory.ApiType.V1
                    )

                val tweets = standardSearchTweet.searchTweet(
                    query, mutableListOf(
                        StandartSearchTweetV1Api.COUNT to 20
                    )
                )
                _tweetState.value = ResultState(data = tweets, state = ResultState.Status.SUCCESS)
            } catch (error: Exception) {
                _tweetState.value = ResultState(error = error, state = ResultState.Status.ERROR)
            }
        }
    }

}