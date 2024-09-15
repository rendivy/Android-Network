package com.yangel.hits_network_lection.data.repositories

import com.yangel.hits_network_lection.data.api.services.CatService
import com.yangel.hits_network_lection.data.mappers.CatApiToDomainMapper
import com.yangel.hits_network_lection.domain.entity.Cat
import com.yangel.hits_network_lection.domain.repositories.CatRepository

/**
 * @author y.yangel
 */
internal class CatRepositoryImpl(
    private val catService: CatService,
    private val apiToDomainMapper: CatApiToDomainMapper,
) : CatRepository {

    override suspend fun getCats(): List<Cat> {
        return catService.getCats(20)
            .map(apiToDomainMapper)
    }
}
