package com.reddit.rickandmortyapp.network

import com.reddit.rickandmortyapp.datas.API.RickAndMortyAPI
import com.reddit.rickandmortyapp.Utils.RickAndMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: RickAndMortyAPI
    )= RickAndMortyRepository(api)

    @Singleton
    @Provides
    fun provideRickAndMortyAPI():RickAndMortyAPI{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://rickandmortyapi.com/api/")
            .build()
            .create(RickAndMortyAPI::class.java)
    }
}