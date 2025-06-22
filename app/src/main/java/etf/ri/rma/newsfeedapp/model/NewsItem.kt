package etf.ri.rma.newsfeedapp.model

import androidx.room.PrimaryKey

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
    val imageTags: ArrayList<String> = arrayListOf()
)

fun NewsItem.toNews(): News {
    return News(
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

