package com.example.netflixclone.Network.Model

data class OnlyNetflix(
    val dates: DatesX,
    val page: Int,
    val results: List<ResultXX>,
    val total_pages: Int,
    val total_results: Int
)