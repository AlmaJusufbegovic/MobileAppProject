package etf.ri.rma.newsfeedapp.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "News",
    indices = [Index(value = ["title"], unique = true)]
)
data class News(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val uuid: String,
    val title: String,
    val snippet: String,
    val imageUrl: String?,
    val category: String,
    val isFeatured: Boolean,
    val source: String,
    val publishedDate: String
)


fun NewsWithTags.toNewsItem(): NewsItem {
    return NewsItem(
        uuid = news.uuid,
        title = news.title,
        snippet = news.snippet,
        imageUrl = news.imageUrl,
        category = news.category,
        isFeatured = news.isFeatured,
        source = news.source,
        publishedDate = news.publishedDate,
        imageTags = ArrayList(imageTags.map { it.value })
    )
}