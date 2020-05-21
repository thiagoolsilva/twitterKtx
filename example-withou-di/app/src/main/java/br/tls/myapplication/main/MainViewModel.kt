package br.tls.myapplication.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.tls.sample.model.ResultState
import br.tls.twitterktx.api.search.factory.SearchTweetFactory
import br.tls.twitterktx.api.search.model.Twitter
import br.tls.twitterktx.api.search.v1.product.StandardSearchTweetV1
import br.tls.twitterktx.api.search.v1.standard.api.StandartSearchTweetV1Api
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

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