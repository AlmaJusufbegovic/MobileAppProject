package etf.ri.rma.newsfeedapp.model

data class ApiNewsItem(
    val uuid: String,
    val title: String,
    val description: String?,
    val snippet: String?,
    val url: String,
    val imageUrl: String?,
    val published_at: String,
    val source: String,
    val categories: List<String>
)

fun ApiNewsItem.toNewsItem(category: String): NewsItem {
    return NewsItem(
        uuid = this.uuid,
        title = this.title,
        snippet = this.description ?: this.snippet ?: "",
        imageUrl = this.imageUrl ?: "",
        category = this.categories.firstOrNull() ?: "general",
        isFeatured = false,
        source = this.source,
        publishedDate = this.published_at,
        imageTags = arrayListOf(),
    )
}
