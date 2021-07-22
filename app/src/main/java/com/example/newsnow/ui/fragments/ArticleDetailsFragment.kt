package com.example.newsnow.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.newsnow.MainActivity
import com.example.newsnow.R
import com.example.newsnow.ui.viewmodel.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article_details.*

class ArticleDetailsFragment : Fragment(R.layout.fragment_article_details) {

    lateinit var viewModel: NewsViewModel
    private val args: ArticleDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        //obtem o artigo atual
        val article = args.article
        //exibe no modo web
        webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }

        //botão para salvar o artigo
        fabFavorite.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved!", Snackbar.LENGTH_SHORT).show()
        }
    }
}