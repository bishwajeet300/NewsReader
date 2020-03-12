package com.bishwajeet.newsreader.view.news.fragmentNewsFeed

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.bishwajeet.newsreader.NewReaderApp
import com.bishwajeet.newsreader.R
import com.bishwajeet.newsreader.model.Article
import com.bishwajeet.newsreader.view.news.fragmentNewsFeed.helper.NewsFeedAdapter
import com.bishwajeet.newsreader.view.news.fragmentNewsFeed.helper.NewsFeedListener
import kotlinx.android.synthetic.main.fragment_news_feed.view.*
import javax.inject.Inject


class NewsFeedFragment : Fragment(), NewsFeedListener {

    private val _tag = "NewsFeedFragment"

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<NewsFeedViewModel> { viewModelFactory }
    private val adapter = NewsFeedAdapter(this as NewsFeedListener)
    private lateinit var binding: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater.inflate(R.layout.fragment_news_feed, container, false)

        initAdapter()
        return binding
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as NewReaderApp).applicationComponent.newsFeedComponent()
            .create()
            .inject(this)
    }


    private fun initAdapter() {
        val manager = GridLayoutManager(activity, resources.getInteger(R.integer.per_row_item))

        manager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return viewModel.getColumnSpan(position, resources.configuration.orientation, Configuration.ORIENTATION_LANDSCAPE)
            }
        }

        binding.gvNewsFeed.layoutManager = manager
        binding.gvNewsFeed.adapter = adapter
        viewModel.data.observe(viewLifecycleOwner, Observer<PagedList<Article>> {
            Log.i(_tag, "Updating list with ${it.size} items")
            adapter.submitList(it)
        })

        viewModel.eventNetworkError.observe(viewLifecycleOwner, Observer<String> {
            Log.i(_tag, it)
        })
    }


    override fun onArticleClick(article: Article) {
        val nav = NewsFeedFragmentDirections.actionNewsFeedFragmentToNewsReaderFragment(article.url)
        findNavController().navigate(nav)
    }
}
