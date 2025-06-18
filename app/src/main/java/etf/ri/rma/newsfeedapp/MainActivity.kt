package etf.ri.rma.newsfeedapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import etf.ri.rma.newsfeedapp.data.network.NewsDAO
import etf.ri.rma.newsfeedapp.data.network.RetrofitInstance
import etf.ri.rma.newsfeedapp.data.network.RetrofitInstanceImaga
import etf.ri.rma.newsfeedapp.navigation.NewsNavHost
import etf.ri.rma.newsfeedapp.ui.theme.NewsFeedAppTheme
import etf.ri.rma.newsfeedapp.viewmodel.NewsFeedViewModel
import etf.ri.rma.newsfeedapp.viewmodel.NewsFeedViewModelFactory
import okhttp3.OkHttpClient

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        NewsDAO.setApiService(RetrofitInstance.provideNewsApiService())

        val imagaDAO = RetrofitInstanceImaga().provideImagaApiService(
            baseURL = "https://api.imagga.com/v2/",
            httpClient = OkHttpClient()
        )

        val viewModel = ViewModelProvider(
            this,
            NewsFeedViewModelFactory(applicationContext)
        )[NewsFeedViewModel::class.java]

        setContent {
            NewsFeedAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NewsNavHost(
                        navController = navController,
                        imagaDAO = imagaDAO,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}
