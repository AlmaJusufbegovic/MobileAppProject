package etf.ri.rma.newsfeedapp.data.network.api

import etf.ri.rma.newsfeedapp.model.ImagaResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ImagaApiService {
    @GET("v2/tags")
    suspend fun getTags(
        @Header("Authorization") auth: String,
        @Query("image_url") imageUrl: String
    ): ImagaResponse
}
