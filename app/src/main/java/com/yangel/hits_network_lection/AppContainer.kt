package com.yangel.hits_network_lection

import android.content.Context
import com.yangel.hits_network_lection.data.api.interceptors.AuthorizationTokenInterceptor
import com.yangel.hits_network_lection.data.api.services.CatService
import com.yangel.hits_network_lection.data.mappers.CatApiToDomainMapper
import com.yangel.hits_network_lection.data.repositories.CatRepositoryImpl
import com.yangel.hits_network_lection.domain.repositories.CatRepository
import com.yangel.hits_network_lection.domain.usecases.GetCatsUseCase
import com.yangel.hits_network_lection.domain.usecases.GetCatsUseCaseImpl
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

/**
 * @author y.yangel
 */
class AppContainer(private val context: Context) {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private fun client(context: Context): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(AuthorizationTokenInterceptor(context))
        }.build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .client(client(context))
            .addConverterFactory(json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()
    }

    private val catService by lazy { retrofit.create(CatService::class.java) }

    private val repository: CatRepository =
        CatRepositoryImpl(catService = catService, apiToDomainMapper = CatApiToDomainMapper())

    val useCase: GetCatsUseCase = GetCatsUseCaseImpl(repository)
}
