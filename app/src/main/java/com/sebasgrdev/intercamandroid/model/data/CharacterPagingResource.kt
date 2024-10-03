package com.sebasgrdev.intercamandroid.model.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sebasgrdev.intercamandroid.model.api.CharactersApi
import com.sebasgrdev.intercamandroid.model.data.response.Result
import com.sebasgrdev.intercamandroid.ui.screens.rickandmorty.model.CharacterModel
import okio.IOException
import javax.inject.Inject

class CharacterPagingResource @Inject constructor(private val api: CharactersApi) : PagingSource<Int,CharacterModel>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {

        return try {
            val page = params.key ?: 1
            val response = api.getAllCharacters(page)
            val characters = response.results
            val prevKey = if (page > 0) page -1 else null
            val nextKey = if (response.info.next != null) page +1 else null

            LoadResult.Page(data = characters.map { it.toModel() }, prevKey = prevKey, nextKey = nextKey)
        } catch (e: IOException) {
            LoadResult.Error(e)
        }

    }

}