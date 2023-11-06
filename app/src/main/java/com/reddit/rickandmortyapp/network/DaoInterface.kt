package com.reddit.rickandmortyapp.network

import com.reddit.rickandmortyapp.model.CharactersCevap
import retrofit2.Call
import retrofit2.http.GET

interface DaoInterface {
    @GET("api/character")
    fun downloadFromAPI():Call<CharactersCevap>
}