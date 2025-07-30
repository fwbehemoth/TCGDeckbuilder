package com.valerunners.tcgdeckbuilder.repos.scryfall

import com.valerunners.tcgdeckbuilder.ScryfallBaseData
import com.valerunners.tcgdeckbuilder.ScryfallCard
import retrofit2.Response
import retrofit2.http.*

interface ScryfallApiCardService {
    @Headers(
        "User-Agent: TCGDeckbuilder/1.0",
        "Accept: */*"
    )
    @GET
    suspend fun getSearchCards(@Url url: String) : Response<ScryfallBaseData>

    @Headers(
        "User-Agent: TCGDeckbuilder/1.0",
        "Accept: */*"
    )
    @GET("/cards/random")
    suspend fun getRandomCard() : Response<ScryfallCard>
}