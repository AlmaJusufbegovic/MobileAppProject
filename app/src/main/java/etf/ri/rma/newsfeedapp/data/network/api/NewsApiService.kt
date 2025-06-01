package etf.ri.rma.newsfeedapp.data.network.api

import etf.ri.rma.newsfeedapp.data.network.NewsResponse
import etf.ri.rma.newsfeedapp.data.network.SimilarNewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("news/top")
    suspend fun getTopStoriesByCategory(
        @Query("api_token") apiKey: String = "6Nl6ScxLBBbNcT6xBSJRmeBvcY48JDebJdH2A4Qx",
        @Query("categories") category: String,
        @Query("locale") locale: String = "en",
        @Query("limit") limit: Int = 3
    ): NewsResponse

    @GET("news/similar")
    suspend fun getSimilarStories(
        @Query("uuid") newsId: String,
        @Query("api_token") apiKey: String = "6Nl6ScxLBBbNcT6xBSJRmeBvcY48JDebJdH2A4Qx",
        @Query("locale") locale: String = "en"
    ): SimilarNewsResponse
}
