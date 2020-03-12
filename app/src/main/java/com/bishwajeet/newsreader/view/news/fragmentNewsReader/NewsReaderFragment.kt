package com.bishwajeet.newsreader.view.news.fragmentNewsReader

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bishwajeet.newsreader.NewReaderApp
import com.bishwajeet.newsreader.R
import kotlinx.android.synthetic.main.fragment_news_reader.view.*
import javax.inject.Inject


class NewsReaderFragment : Fragment() {

    private val _tag = "NewsReaderFragment"

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<NewsReaderViewModel> { viewModelFactory }
    private lateinit var binding: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater.inflate(R.layout.fragment_news_reader, container, false)

        binding.webview.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {}

            override fun onConsoleMessage(cm: ConsoleMessage): Boolean {
                return true
            }
        }

        binding.webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        }

        viewModel.url.observe(viewLifecycleOwner, Observer {
            Log.d(_tag, it)
            binding.webview.loadUrl(it)
        })

        return binding
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as NewReaderApp).applicationComponent.newsReaderComponent()
            .create()
            .inject(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.saveUrl(arguments?.getString("URL"))
    }
}
