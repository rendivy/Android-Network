package com.yangel.hits_network_lection.domain.repositories

import com.yangel.hits_network_lection.domain.entity.Cat

/**
 * @author y.yangel
 */
interface CatRepository {
    suspend fun getCats(): List<Cat>
}
