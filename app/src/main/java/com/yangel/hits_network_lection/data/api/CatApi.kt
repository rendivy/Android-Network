package com.yangel.hits_network_lection.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author y.yangel
 */
@Serializable
internal class CatApi(
    @SerialName("url")
    val url: String,
    @SerialName("id")
    val id: String,
)
