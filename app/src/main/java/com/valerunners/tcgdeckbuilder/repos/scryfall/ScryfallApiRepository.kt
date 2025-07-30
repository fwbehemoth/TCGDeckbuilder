package com.valerunners.tcgdeckbuilder.repos.scryfall

import com.valerunners.tcgdeckbuilder.ScryfallBaseData
import com.valerunners.tcgdeckbuilder.ScryfallCard
import com.valerunners.tcgdeckbuilder.repos.Resource

class ScryfallApiRepository {
    suspend fun getRandomCard(): Resource<ScryfallCard> {
        return try{
            val service = ScryfallRetrofitInstance
                .getScryfallRetrofitInstance().create(ScryfallApiCardService::class.java)
            val response = service.getRandomCard()
            if (response.isSuccessful) {
                response.body()?.let{
                    Resource.Success(it)
                }?: Resource.Error("Response body is empty")
            } else {
                Resource.Error("Error: ${response.code()} - ${response.message()}")
            }
        } catch (e: Exception){
            Resource.Error("Failed to fetch posts: ${e.message}")
        }
    }

    suspend fun getSearch(searchQuery: String): Resource<ScryfallBaseData> {
        return try{
            val service = ScryfallRetrofitInstance
                .getScryfallRetrofitInstance().create(ScryfallApiCardService::class.java)
            val response = service.getSearchCards(searchQuery)
            if (response.isSuccessful) {
                response.body()?.let{
                    Resource.Success(it)
                }?: Resource.Error("Response body is empty")
            } else {
                Resource.Error("Error: ${response.code()} - ${response.message()}")
            }
        } catch (e: Exception){
            Resource.Error("Failed to fetch posts: ${e.message}")
        }
    }
}