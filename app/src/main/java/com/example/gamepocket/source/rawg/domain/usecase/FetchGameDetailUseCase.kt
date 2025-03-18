package com.example.gamepocket.source.rawg.domain.usecase

import com.example.gamepocket.source.rawg.data.Resource
import com.example.gamepocket.source.rawg.data.repository.GameDetailRepository
import com.example.gamepocket.source.rawg.domain.mapper.toDomain
import com.example.gamepocket.source.rawg.utils.map
import javax.inject.Inject
import kotlinx.coroutines.flow.flow

class FetchGameDetailUseCase @Inject constructor(private val repository: GameDetailRepository) {

    operator fun invoke(id: Int) = flow {
        emit(Resource.of { repository.fetchGameDetail(id).map { it.toDomain() } })
    }
}