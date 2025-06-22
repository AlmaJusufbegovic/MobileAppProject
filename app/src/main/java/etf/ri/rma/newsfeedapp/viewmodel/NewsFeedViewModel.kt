package etf.ri.rma.newsfeedapp.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import etf.ri.rma.newsfeedapp.data.network.NewsDAO
import etf.ri.rma.newsfeedapp.model.NewsItem
import etf.ri.rma.newsfeedapp.data.NewsDatabase
import etf.ri.rma.newsfeedapp.model.toNews
import etf.ri.rma.newsfeedapp.model.toNewsItem
import kotlinx.coroutines.launch

class NewsFeedViewModel(context: Context) : ViewModel() {
    private val dao = NewsDatabase.getInstance(context).savedNewsDAO()
    private val _newsList = mutableStateListOf<NewsItem>()
    val newsList: List<NewsItem> get() = _newsList

    var isLoading by mutableStateOf(false)
        private set

    init {
        viewModelScope.launch {
            try {
                NewsDAO.initStaticNews(context) // učitaj vijesti iz mock podataka
                val fetchedNews = NewsDAO.getAllStories()

                // Pokušaj da sačuvaš sve vijesti i njihove tagove u bazu
                for (item in fetchedNews) {
                    val saved = dao.saveNews(item)
                    val id = dao.getNewsByUuid(item.uuid)?.id
                    if (saved && id != null) {
                        dao.addTags(item.imageTags, id)
                    }
                }

                _newsList.clear()
                _newsList.addAll(fetchedNews)

            } catch (e: Exception) {
                // Ako ne uspije (npr. nema interneta), čitaj iz baze
                val allFromDb = dao.getAllNewsWithTags().map { it.toNewsItem() }
                _newsList.clear()
                _newsList.addAll(allFromDb)
            }
        }
    }

    fun loadNews(category: String) {
        viewModelScope.launch {
            isLoading = true
            try {
                val items = NewsDAO.getTopStoriesByCategory(category)
                NewsDAO.addFetchedNews(items)

                for (item in items) {
                    val saved = dao.saveNews(item)
                    val id = dao.getNewsByUuid(item.uuid)?.id
                    if (saved && id != null) {
                        dao.addTags(item.imageTags, id)
                    }
                }

                _newsList.clear()
                _newsList.addAll(items)

            } catch (e: Exception) {
                val fromDb = dao.getNewsWithCategoryWithTags(category).map { it.toNewsItem() }
                _newsList.clear()
                _newsList.addAll(fromDb)
            }

            isLoading = false
        }
    }
}
