package etf.ri.rma.newsfeedapp.data.network

import androidx.annotation.OptIn
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import etf.ri.rma.newsfeedapp.data.network.api.NewsApiService
import etf.ri.rma.newsfeedapp.data.network.exception.InvalidUUIDException
import etf.ri.rma.newsfeedapp.model.NewsItem
import etf.ri.rma.newsfeedapp.model.toNewsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

object NewsDAO {
    private val allStories = mutableListOf<NewsItem>()
    private val fetchedTimestamps = mutableMapOf<String, Long>()
    private val staticNews = mutableListOf<NewsItem>()

    private var initialized = false

    private val validCategories = listOf(
        "general", "science", "sports", "business",
        "health", "entertainment", "tech", "politics", "food", "travel"
    )


    @OptIn(UnstableApi::class)
    private var apiService: NewsApiService? = null

    fun setApiService(service: NewsApiService) {
        if (apiService != null) return
        apiService = service
    }

    fun getApiService(): NewsApiService? = apiService

    fun resetApiService() {
        apiService = null
    }

    @OptIn(UnstableApi::class)
    suspend fun getTopStoriesByCategory(category: String): List<NewsItem> = withContext(Dispatchers.IO) {
        if (category !in validCategories) return@withContext emptyList()

        val currentTime = System.currentTimeMillis()
        val lastFetched = fetchedTimestamps[category] ?: 0

        val cached = allStories.filter { it.category == category }
        if (currentTime - lastFetched < 30_000) {
            return@withContext cached
        }

        val apiKey = "6Nl6ScxLBBbNcT6xBSJRmeBvcY48JDebJdH2A4Qx"
        try{
            val response = apiService?.getTopStoriesByCategory(
                apiKey = apiKey,
                category = category
            ) ?: return@withContext emptyList()

            Log.d("API_RESPONSE", "Fetched ${response.data.size} items for category $category")


            val newStories = response.data.map { it.toNewsItem(category) }

            newStories.forEach { addStoryIfNotExists(it) }
            fetchedTimestamps[category] = currentTime

            val featured = newStories.take(3)
            val standard = cached.filterNot { cachedItem ->
                cachedItem.uuid in featured.map { featuredItem -> featuredItem.uuid }
            }

            return@withContext featured + standard
        }catch (e: Exception) {
            Log.e("API_ERROR", "Greška prilikom API poziva: ${e.message}", e)
            return@withContext emptyList()
        }
    }

    fun getAllStories(): List<NewsItem> {
        allStories.addAll(StaticNewsData.predefinedNews)
        return allStories
    }

    fun addFetchedNews(news: List<NewsItem>) {
        news.forEach {
            if (allStories.none { existing -> existing.uuid == it.uuid }) {
                allStories.add(it)
            }
        }
    }

    fun initStaticNews() {
        if (initialized) return

        StaticNewsData.predefinedNews.forEach {
            addStoryIfNotExists(it)
            staticNews.add(it)
        }

        initialized = true
    }



    suspend fun getSimilarStories(uuid: String): List<NewsItem> = withContext(Dispatchers.IO) {
        if (!isValidUUID(uuid)) throw InvalidUUIDException("Invalid UUID format")

        val response = apiService?.getSimilarStories(newsId = uuid)
            ?: return@withContext emptyList()

        return@withContext response.data
    }


    private fun addStoryIfNotExists(story: NewsItem) {
        if (allStories.none { it.uuid == story.uuid }) {
            allStories.add(story)
        }
    }

    private fun isValidUUID(uuid: String): Boolean {
        return try {
            UUID.fromString(uuid)
            true
        } catch (e: Exception) {
            false
        }
    }
}
