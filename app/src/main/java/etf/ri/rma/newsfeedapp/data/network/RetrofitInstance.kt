package etf.ri.rma.newsfeedapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import etf.ri.rma.newsfeedapp.data.network.api.NewsApiService

object RetrofitInstance {
    private const val BASE_URL = "https://api.thenewsapi.com/v1/"

    fun provideNewsApiService(): NewsApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }
}
