package etf.ri.rma.newsfeedapp.data

import etf.ri.rma.newsfeedapp.model.NewsItem
import java.util.*

object NewsData {
    fun getAllNews(): List<NewsItem> {
        return List(25) { index ->
            val category = when {
                index % 3 == 0 -> "Politika"
                index % 3 == 1 -> "Sport"
                else -> "Nauka/tehnologija"
            }
            NewsItem(
                id = index.toString(),
                title = "Naslov vijesti broj $index",
                snippet = "Ovo je kratak opis vijesti broj $index",
                imageUrl = null,
                category = category,
                isFeatured = index % 5 == 0,
                source = "Izvor $index",
                publishedDate = "2025-04-${(index % 30) + 1}"
            )
        }
    }
}
