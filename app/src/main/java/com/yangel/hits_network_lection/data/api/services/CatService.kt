package com.yangel.hits_network_lection.data.api.services

import com.yangel.hits_network_lection.data.api.CatApi
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author y.yangel
 */
internal interface CatService {

    @GET("images/search")
    suspend fun getCats(@Query("limit") limit: Int): List<CatApi>
}
