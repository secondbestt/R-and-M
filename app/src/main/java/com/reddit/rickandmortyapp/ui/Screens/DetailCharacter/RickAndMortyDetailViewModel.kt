package com.reddit.rickandmortyapp.ui.Screens.DetailCharacter

import androidx.lifecycle.ViewModel
import com.reddit.rickandmortyapp.datas.API.Response.CharacterInfo.CharacterInfo
import com.reddit.rickandmortyapp.Utils.RickAndMortyRepository
import com.reddit.rickandmortyapp.Utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RickAndMortyDetailViewModel
@Inject
constructor(
    private val repository: RickAndMortyRepository
): ViewModel(){

    suspend fun getCharacterInfo(characterId: Int):Resource<CharacterInfo>{
        return repository.getCharacterInfo(characterId)
    }

}
