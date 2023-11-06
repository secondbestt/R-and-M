package com.reddit.rickandmortyapp.Utils

import com.reddit.rickandmortyapp.network.DaoInterface
import com.reddit.rickandmortyapp.network.RetrofitClient


class ApiUtills {

    companion object{
        //https://rickandmortyapi.com/api/character
        val BASE_URL = "https://rickandmortyapi.com/"
        fun getDaoInterface(): DaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(DaoInterface::class.java)
        }
    }
}