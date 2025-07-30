package com.valerunners.tcgdeckbuilder.repos.edhrec

import com.valerunners.tcgdeckbuilder.datamodels.edhrec.EdhrecCommander
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EdhrecApiService {
    @GET("pages/commanders/{name}.json")
    suspend fun getCommander(@Path("name") name: String): Response<EdhrecCommander>
}