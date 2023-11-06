package com.reddit.rickandmortyapp.datas.API.Response.Locations

data class Result(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)