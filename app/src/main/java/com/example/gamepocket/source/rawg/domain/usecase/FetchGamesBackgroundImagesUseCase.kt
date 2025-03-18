package com.example.gamepocket.source.rawg.domain.usecase

import com.example.gamepocket.source.rawg.data.Resource
import com.example.gamepocket.source.rawg.data.repository.GameDetailRepository
import com.example.gamepocket.source.rawg.domain.mapper.toGameImage
import com.example.gamepocket.source.rawg.domain.model.GameImage
import com.example.gamepocket.source.rawg.utils.map
import javax.inject.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class FetchGamesBackgroundImagesUseCase @Inject constructor(private val repository: GameDetailRepository) {
    operator fun invoke(ids: List<Int>) = flow<Resource<List<GameImage>>> {
        val images = ids.map { id ->
            repository.fetchGameDetail(id).map { it.toGameImage() }.body()
        }
        emit(Resource.Success(images.filterNotNull()))
    }.onStart { emit(Resource.Loading(ids.map { GameImage(it, "") })) }
        .catch { emit(Resource.Error(it)) }
}