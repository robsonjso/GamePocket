package com.example.gamepocket.source.rawg.domain.usecase

import com.example.gamepocket.source.rawg.data.Resource
import com.example.gamepocket.source.rawg.data.repository.GameDetailRepository
import com.example.gamepocket.source.rawg.domain.mapper.toDomain
import com.example.gamepocket.source.rawg.utils.map
import javax.inject.Inject
import kotlinx.coroutines.flow.flow

class FetchGameScreenshotsUseCase @Inject constructor(private val repository: GameDetailRepository) {

    operator fun invoke(id: Int) = flow {
        emit(Resource.of {
            repository.fetchGameScreenshots(id).map { response ->
                response.results.orEmpty().map { it.toDomain() }
            }
        })
    }
}