package com.yangel.hits_network_lection.data.api.interceptors

import android.content.Context
import com.yangel.hits_network_lection.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author y.yangel
 */
class AuthorizationTokenInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("x-api-key", BuildConfig.API_KEY)
            .build()
        return chain.proceed(request)
    }

}
