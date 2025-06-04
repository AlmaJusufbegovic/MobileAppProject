package etf.ri.rma.newsfeedapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import etf.ri.rma.newsfeedapp.data.network.api.NewsApiService
import etf.ri.rma.newsfeedapp.data.network.api.ImagaApiService
import okhttp3.OkHttpClient

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

class RetrofitInstanceImaga {
    fun provideImagaApiService(baseURL:String,httpClient:OkHttpClient):ImagaDAO{
        val imagaDAO = ImagaDAO()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .client(httpClient)
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
        val imagaApiService = retrofit.create(ImagaApiService::class.java)
        imagaDAO.setApiService(imagaApiService)
        return imagaDAO
    }
}