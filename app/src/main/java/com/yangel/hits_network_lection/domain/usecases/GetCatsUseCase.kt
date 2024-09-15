package com.yangel.hits_network_lection.domain.usecases

import com.yangel.hits_network_lection.domain.entity.Cat

/**
 * @author y.yangel
 */
interface GetCatsUseCase {
    suspend operator fun invoke() : List<Cat>
}
