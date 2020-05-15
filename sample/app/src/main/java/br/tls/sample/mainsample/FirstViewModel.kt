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
import br.tls.twitterktx.api.search.SearchApi
import br.tls.twitterktx.api.search.model.Twitter
import kotlinx.coroutines.launch
import java.lang.Exception

class FirstViewModel constructor(val tweeterApi: SearchApi) : ViewModel() {

    sealed class SearchTweeter {
        class TweetState : SearchTweeter()
    }

    private val _tweetState = MutableLiveData<ResultState<Twitter>>()
    val tweetState: LiveData<ResultState<Twitter>>
        get() = _tweetState

    fun searchTrendTweet() {
        viewModelScope.launch {
            try {
                val tweets = tweeterApi.searchTweeter()
                _tweetState.value = ResultState(data = tweets, state = ResultState.Status.SUCCESS)
            } catch (error: Exception) {
                _tweetState.value = ResultState(error = error,  state = ResultState.Status.ERROR)
            }
        }
    }

}