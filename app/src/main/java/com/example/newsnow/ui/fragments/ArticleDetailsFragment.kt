package com.example.newsnow.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.newsnow.MainActivity
import com.example.newsnow.R
import com.example.newsnow.model.Article
import com.example.newsnow.ui.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article_details.*

class ArticleDetailsFragment : Fragment(R.layout.fragment_article_details) {

    lateinit var viewmodel: NewsViewModel
    val args: ArticleDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel = (activity as MainActivity).viewModel

        val article = args.article

        webView.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                webViewClient = webViewClient
            }
            article.url?.let { loadUrl(it) }
        }
    }

}