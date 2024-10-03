package com.sebasgrdev.intercamandroid.model.api

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sebasgrdev.intercamandroid.model.data.CharacterPagingResource
import com.sebasgrdev.intercamandroid.model.data.response.Result
import com.sebasgrdev.intercamandroid.ui.screens.rickandmorty.model.CharacterModel
import com.sebasgrdev.intercamandroid.utils.Constants.Companion.MAX_ITEM
import com.sebasgrdev.intercamandroid.utils.Constants.Companion.PREFETCH_ITEMS
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharactersRepository @Inject constructor (private val api: CharactersApi) {
    fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(config = PagingConfig(pageSize = MAX_ITEM, prefetchDistance = PREFETCH_ITEMS), pagingSourceFactory = {
            CharacterPagingResource(api)
        }).flow
    }
}