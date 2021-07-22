package com.example.newsnow

class Constants {

    companion object {
        const val KEY = "f39b98e3207140778b057b3c08289266"
        const val URL = "https://newsapi.org"
        const val QUERY_PAGE = 15
        const val SEARCH_DELAY = 500L

        var isLoading = false
        var isLastPage = false
        var isScrolling = false
    }
}