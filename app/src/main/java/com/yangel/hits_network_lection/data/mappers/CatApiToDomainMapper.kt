package com.yangel.hits_network_lection.data.mappers

import com.yangel.hits_network_lection.data.api.CatApi
import com.yangel.hits_network_lection.domain.entity.Cat
import kotlin.random.Random

/**
 * @author y.yangel
 */
internal class CatApiToDomainMapper : (CatApi) -> Cat {

    private val facts: List<String> = listOf(
        "The technical term for a cat’s hairball is a “bezoar.",
        "When a cat chases its prey, it keeps its head level. Dogs and humans bob their heads up and down.",
        "Unlike dogs, cats do not have a sweet tooth. Scientists believe this is due to a mutation in a key taste receptor.",
        "A cat can’t climb head first down a tree because every claw on a cat’s paw points the same way. To get down from a tree, a cat must back down.",
        "Cats make about 100 different sounds. Dogs make only about 10.",
        "Approximately 24 cat skins can make a coat.",
    )

    override fun invoke(from: CatApi): Cat {
        return Cat(
            id = from.id,
            imageUrl = from.url,
            facts = facts.random()
        )
    }
}
