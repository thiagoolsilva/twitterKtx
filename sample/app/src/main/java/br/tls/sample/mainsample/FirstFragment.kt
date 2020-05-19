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

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.tls.sample.R
import br.tls.sample.model.ResultState
import br.tls.twitterktx.api.oauth2.OAuth2BearerFactory
import br.tls.twitterktx.api.search.v1.model.Twitter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_first.*
import org.koin.android.ext.android.inject
import timber.log.Timber

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val oAuth2BearerFactory:OAuth2BearerFactory by inject()
    private val firstViewModel: FirstViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSendToken.setOnClickListener {
            val tokenAuth = edtOauth2BearerToken.text.toString()
            if(tokenAuth.isNotEmpty()) {
                oAuth2BearerFactory.oauth2BearerToken = tokenAuth
                Snackbar.make(parent, "The OAuth2BearerToken was successfully set", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(parent, "It is not possible to set empty OAuth2BearerToken", Snackbar.LENGTH_LONG).show()
            }
        }

        btnSearchTweet.setOnClickListener {
            val tweetQuery = edtSearchTweet.text.toString()
            if(tweetQuery.isNotEmpty()) {
                firstViewModel.searchTrendTweet(tweetQuery)
            } else {
                Snackbar.make(parent, "It is not possible to perform a twitter query with empty value", Snackbar.LENGTH_LONG).show()
            }
            edtSearchTweet.text.clear()
        }

        firstViewModel.tweetState.observe(viewLifecycleOwner, Observer {
            when (it.state) {
                ResultState.Status.SUCCESS -> handleTweets(it.data)
                ResultState.Status.ERROR -> handleGenericErrorStatus(it.error)
            }
        })
    }

    private fun handleGenericErrorStatus(error:Exception?) {
        error?.let {
            Timber.e(it)
        } ?: kotlin.run {
            Timber.d("The error message was not provided by ViewModel")
        }
    }

    private fun handleTweets(data: Twitter?) {
        Snackbar.make(parent ,"check twitter data on logcat", Snackbar.LENGTH_LONG).show()
        data?.let {
            Timber.d("tweet count %d", it.statuses.size)
            it.statuses.forEach {
                Timber.d("message [%s]", it.text)
            }
        } ?: kotlin.run {
            Timber.d("No data received from twitter api")
        }
    }

}
