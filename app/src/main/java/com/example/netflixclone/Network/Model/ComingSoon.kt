package com.example.netflixclone.Network.Model

data class ComingSoon(
    val dates: Dates,
    val page: Int,
    val results: List<ResultX>,
    val total_pages: Int,
    val total_results: Int
)