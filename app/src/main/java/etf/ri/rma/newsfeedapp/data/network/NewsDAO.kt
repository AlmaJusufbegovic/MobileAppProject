package etf.ri.rma.newsfeedapp.data.network

import android.content.Context
import androidx.annotation.OptIn
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import etf.ri.rma.newsfeedapp.data.network.api.NewsApiService
import etf.ri.rma.newsfeedapp.data.network.exception.InvalidUUIDException
import etf.ri.rma.newsfeedapp.model.NewsItem
import etf.ri.rma.newsfeedapp.data.NewsDatabase
import etf.ri.rma.newsfeedapp.model.toNewsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

object NewsDAO {
    private val allStories = mutableListOf<NewsItem>()
    private val fetchedTimestamps = mutableMapOf<String, Long>()

    private val validCategories = listOf(
        "general", "science", "sports", "business",
        "health", "entertainment", "tech", "politics", "food", "travel"
    )

    private var apiService: NewsApiService = RetrofitInstance.provideNewsApiService()

    fun setApiService(service: NewsApiService) {
        apiService = service
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
            val response = apiService.getTopStoriesByCategory(
                apiKey = apiKey,
                category = category
            )

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

    suspend fun initStaticNews(context: Context) {
        val dao = NewsDatabase.getInstance(context).savedNewsDAO()

        if (dao.getAllNewsWithTags().isNotEmpty()) return

        for (news in StaticNewsData.predefinedNews) {
            val saved = dao.saveNews(news)
            val id = dao.getNewsByUuid(news.uuid)?.id
            if (saved && id != null) {
                dao.addTags(news.imageTags, id)
            }
        }
    }

    suspend fun getSimilarStories(uuid: String): List<NewsItem> = withContext(Dispatchers.IO) {
        if (!isValidUUID(uuid)) throw InvalidUUIDException("Invalid UUID format")

        val response = apiService.getSimilarStories(newsId = uuid)

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