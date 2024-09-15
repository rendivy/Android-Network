package com.yangel.hits_network_lection.domain.usecases

import com.yangel.hits_network_lection.domain.entity.Cat
import com.yangel.hits_network_lection.domain.repositories.CatRepository

/**
 * @author y.yangel
 */
class GetCatsUseCaseImpl(private val repository: CatRepository) : GetCatsUseCase {

    override suspend fun invoke(): List<Cat> = repository.getCats()

}
