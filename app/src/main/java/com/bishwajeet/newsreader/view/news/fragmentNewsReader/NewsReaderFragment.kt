package com.bishwajeet.newsreader.view.news.fragmentNewsReader

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bishwajeet.newsreader.R

/**
 * A simple [Fragment] subclass.
 */
class NewsReaderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_reader, container, false)
    }

}
