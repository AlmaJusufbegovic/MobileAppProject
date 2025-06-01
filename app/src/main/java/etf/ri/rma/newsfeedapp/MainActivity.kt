package etf.ri.rma.newsfeedapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import etf.ri.rma.newsfeedapp.navigation.NewsNavHost
import etf.ri.rma.newsfeedapp.ui.theme.NewsFeedAppTheme
import okhttp3.OkHttpClient
import etf.ri.rma.newsfeedapp.data.network.TestS3PripremljenRetrofit


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val imagaDAO = TestS3PripremljenRetrofit().getImaggaDAOwithBaseURL(
            baseURL = "https://api.imagga.com/v2/",
            httpClient = OkHttpClient()
        )

        setContent {
            NewsFeedAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NewsNavHost(navController = navController, imagaDAO = imagaDAO)
                }
            }
        }
    }
}