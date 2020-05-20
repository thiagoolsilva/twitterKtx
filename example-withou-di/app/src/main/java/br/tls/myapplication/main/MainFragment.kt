package br.tls.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import br.tls.myapplication.R
import br.tls.sample.model.ResultState
import br.tls.twitterktx.api.TwitterKtx
import br.tls.twitterktx.api.search.v1.model.Twitter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_first.*
import timber.log.Timber

class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configViews()
    }

    private fun configViews() {
        btnSendToken.setOnClickListener {
            val tokenAuth = edtOauth2BearerToken.text.toString()
            if(tokenAuth.isNotEmpty()) {
                TwitterKtx.configToken(tokenAuth)
                Snackbar.make(parent, "The OAuth2BearerToken was successfully set", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(parent, "It is not possible to set empty OAuth2BearerToken", Snackbar.LENGTH_LONG).show()
            }
        }

        btnSearchTweet.setOnClickListener {
            val tweetQuery = edtSearchTweet.text.toString()
            if(tweetQuery.isNotEmpty()) {
                mainViewModel.searchTrendTweet(tweetQuery)
            } else {
                Snackbar.make(parent, "It is not possible to perform a twitter query with empty value", Snackbar.LENGTH_LONG).show()
            }
            edtSearchTweet.text.clear()
        }

        mainViewModel.tweetState.observe(viewLifecycleOwner, Observer {
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
