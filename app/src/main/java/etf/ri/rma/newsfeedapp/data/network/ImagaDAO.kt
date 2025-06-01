package etf.ri.rma.newsfeedapp.data.network

import etf.ri.rma.newsfeedapp.data.network.api.ImagaApiService
import etf.ri.rma.newsfeedapp.data.network.exception.InvalidImageURLException
import java.net.URL

class ImagaDAO {
    private val cache = mutableMapOf<String, List<String>>()
    private lateinit var apiService: ImagaApiService

    fun setApiService(service: ImagaApiService) {
        this.apiService = service
    }
     suspend fun getTags(imageUrl: String): List<String> {
        if (!isValidUrl(imageUrl)) throw InvalidImageURLException("Neispravan URL slike")
        cache[imageUrl]?.let { return it }

        val credentials = android.util.Base64.encodeToString(
            "acc_87313ecedda33ad:fb2b2fb9584b78f53be8a037b823eed2".toByteArray(),
            android.util.Base64.NO_WRAP
        )
        val authHeader = "Basic $credentials"

        val response = apiService.getTags(authHeader, imageUrl)

        val tagList = response.result.tags.mapNotNull { it.tag["en"] }.take(5)

        cache[imageUrl] = tagList
        return tagList
    }

    private fun isValidUrl(url: String): Boolean {
        return try {
            URL(url)
            true
        } catch (e: Exception) {
            false
        }
    }
}
