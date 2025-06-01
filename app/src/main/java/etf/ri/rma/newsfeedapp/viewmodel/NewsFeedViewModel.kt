package etf.ri.rma.newsfeedapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import etf.ri.rma.newsfeedapp.data.network.NewsDAO
import etf.ri.rma.newsfeedapp.model.NewsItem
import kotlinx.coroutines.launch

class NewsFeedViewModel : ViewModel() {
    private val _newsList = mutableStateListOf<NewsItem>()
    val newsList: List<NewsItem> get() = _newsList

    var isLoading by mutableStateOf(false)
        private set

    init {
        viewModelScope.launch {
            NewsDAO.initStaticNews()
            _newsList.clear()
            _newsList.addAll(NewsDAO.getAllStories())
        }
    }

    fun loadNews(category: String) {
        viewModelScope.launch {
            isLoading = true
            try {
                val items = NewsDAO.getTopStoriesByCategory(category)
                NewsDAO.addFetchedNews(items)
                android.util.Log.d("LOAD_NEWS", "Loaded ${items.size} items for category $category")
                _newsList.clear()
                _newsList.addAll(items)
            } catch (e: Exception) {
                android.util.Log.e("LOAD_NEWS_ERROR", "Error: ${e.message}", e)
            }
            isLoading = false
        }
    }

}
