package com.reddit.rickandmortyapp.Utils


import com.reddit.rickandmortyapp.datas.API.Response.CharacterInfo.CharacterInfo
import com.reddit.rickandmortyapp.datas.API.Response.Episode.EpisodeList
import com.reddit.rickandmortyapp.datas.API.Response.Locations.LocationList
import com.reddit.rickandmortyapp.datas.API.Response.RickAndMortyList
import com.reddit.rickandmortyapp.datas.API.RickAndMortyAPI
import com.reddit.rickandmortyapp.Utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class RickAndMortyRepository
@Inject
constructor(
    private val api: RickAndMortyAPI
) {
    suspend fun getRickAndMortyList(page: Int): Resource<RickAndMortyList> {
        val response = try {
            api.getRickAndMortyList(page = page)
        }catch (e:Exception){
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getCharacterInfo(characterId: Int):Resource<CharacterInfo>{
        val response = try {
            api.getCharacterInfo(characterId)
        }catch (e: Exception){
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }


    suspend fun getCharacterByStatusAndGender(
        page: Int,
        name: String,
        status: String,
        gender: String
    ):Resource<RickAndMortyList>{
        val response = try {
            api.getCharacterByStatusAndGender(
                page = page,
                name = name,
                status = status,
                gender = gender
            )
        }catch (e: Exception){
            return Resource.Error("Character not found")
        }
        return Resource.Success(response)
    }


    suspend fun getLocations(pageId: Int):Resource<LocationList>{
        val response = try{
            api.getLocations(pageId)
        }catch (e: Exception){
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getEpisodes(pageId: Int):Resource<EpisodeList>{
        val response = try{
            api.getEpisodes(pageId)
        }catch (e: Exception){
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }


}