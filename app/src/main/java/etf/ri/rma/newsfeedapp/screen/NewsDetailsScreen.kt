package etf.ri.rma.newsfeedapp.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs
import etf.ri.rma.newsfeedapp.data.NewsData
import java.text.ParseException

@Composable
fun NewsDetailsScreen(newsId: String, navController: NavController) {
    val newsList = remember { NewsData.getAllNews() }
    val selectedNews = newsList.find { it.id == newsId }

    if (selectedNews == null) {
        Text("Vijest nije pronađena.")
        return
    }
    println("News ID: $newsId")

    val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    val selectedDate = sdf.parse(selectedNews.publishedDate)

    val relatedNews = newsList
        .filter { it.category == selectedNews.category && it.id != selectedNews.id }
        .sortedBy {
            val date = try {
                sdf.parse(it.publishedDate)
            } catch (e: ParseException) {
                null
            }
            if (date != null && selectedDate != null) {
                abs(date.time - selectedDate.time)
            } else {
                Long.MAX_VALUE  // stavlja neispravne datume na kraj
            }
        }
        .take(2)



    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = selectedNews.title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.testTag("details_title")
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = selectedNews.snippet,
            modifier = Modifier.testTag("details_snippet")
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Kategorija: ${selectedNews.category}",
            modifier = Modifier.testTag("details_category")
        )
        Text(
            text = "Izvor: ${selectedNews.source}",
            modifier = Modifier.testTag("details_source")
        )
        Text(
            text = "Datum: ${selectedNews.publishedDate}",
            modifier = Modifier.testTag("details_date")
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Povezane vijesti iz iste kategorije",
            style = MaterialTheme.typography.titleMedium
        )

        relatedNews.forEachIndexed { index, related ->
            Text(
                text = related.title,
                modifier = Modifier
                    .testTag("related_news_title_${index + 1}")
                    .padding(vertical = 4.dp)
                    .clickable {
                        navController.navigate("details/${related.id}") {
                            popUpTo("details/${selectedNews.id}") { inclusive = true }
                        }
                    },
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { navController.popBackStack("home", inclusive = false) },
            modifier = Modifier.testTag("details_close_button")
        ) {
            Text("Zatvori detalje")
        }
    }
}



