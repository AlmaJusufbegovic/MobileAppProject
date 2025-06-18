package etf.ri.rma.newsfeedapp.screen

import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import etf.ri.rma.newsfeedapp.data.network.ImagaDAO
import etf.ri.rma.newsfeedapp.data.network.exception.InvalidImageURLException
import etf.ri.rma.newsfeedapp.data.network.NewsDAO
import etf.ri.rma.newsfeedapp.model.NewsItem
import etf.ri.rma.newsfeedapp.viewmodel.NewsFeedViewModel
import retrofit2.HttpException
import android.util.Log

@Composable
fun NewsDetailsScreen(
    newsId: String,
    navController: NavController,
    viewModel: NewsFeedViewModel,
    imagaDAO: ImagaDAO
) {
    val newsList = viewModel.newsList
    val selectedNews = newsList.find { it.uuid == newsId }

    val tags = remember { mutableStateListOf<String>() }
    val similarNews = remember { mutableStateListOf<NewsItem>() }

    if (selectedNews == null) {
        Text("Vijest nije pronađena.")
        return
    }

    LaunchedEffect(newsId) {
        if (selectedNews.imageTags.isEmpty()) {
            try {
                val result = imagaDAO.getTags(selectedNews.imageUrl.toString())
                selectedNews.imageTags.addAll(result)
                tags.addAll(result)
            } catch (e: InvalidImageURLException) {
                //
            }
        } else {
            tags.addAll(selectedNews.imageTags)
        }
    }

    LaunchedEffect(newsId) {
        if (similarNews.isEmpty()) {
            try {
                val result = NewsDAO.getSimilarStories(newsId)
                similarNews.addAll(result)
            } catch (e: HttpException) {
                if (e.code() == 404) {
                    Log.e("NewsDetails", "404 - Vijest s UUID $newsId nije pronađena na serveru.")
                } else {
                    Log.e("NewsDetails", "API greška: ${e.code()}")
                }
            } catch (e: Exception) {
                Log.e("NewsDetails", "Greška: ${e.message}")
            }
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = selectedNews.title, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNews.snippet)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Kategorija: ${selectedNews.category}")
        Text(text = "Izvor: ${selectedNews.source}")
        Text(text = "Datum: ${selectedNews.publishedDate}")

        if (tags.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text("Tagovi slike:", style = MaterialTheme.typography.titleMedium)
            tags.forEach {
                Text("- $it")
            }
        }

        if (similarNews.isNotEmpty()) {
            Spacer(modifier = Modifier.height(24.dp))
            Text("Slične vijesti", style = MaterialTheme.typography.titleMedium)

            similarNews.forEach { related ->
                Text(
                    text = related.title,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .clickable {
                            navController.navigate("details/${related.uuid}") {
                                popUpTo("details/${selectedNews.uuid}") { inclusive = true }
                            }
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.popBackStack("home", inclusive = false) }) {
            Text("Zatvori detalje")
        }
    }
}