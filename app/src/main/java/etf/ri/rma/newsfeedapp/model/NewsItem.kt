package etf.ri.rma.newsfeedapp.model

import androidx.room.PrimaryKey
import etf.ri.rma.newsfeedapp.model.db.NewsEntity

class NewsItem (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val uuid: String,
    val title: String,
    val snippet: String,
    val imageUrl: String?,
    val category: String,
    val isFeatured: Boolean,
    val source: String,
    val publishedDate: String,
    val imageTags: ArrayList<String>
)

fun NewsItem.toEntity(): NewsEntity {
    return NewsEntity(
        uuid = uuid,
        title = title,
        snippet = snippet,
        imageUrl = imageUrl,
        category = category,
        isFeatured = isFeatured,
        source = source,
        publishedDate = publishedDate
    )
}

