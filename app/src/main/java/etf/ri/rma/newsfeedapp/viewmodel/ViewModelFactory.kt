package etf.ri.rma.newsfeedapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewsFeedViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsFeedViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NewsFeedViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
