package etf.ri.rma.newsfeedapp.data.network

import etf.ri.rma.newsfeedapp.model.ApiNewsItem
import etf.ri.rma.newsfeedapp.model.NewsItem

data class NewsResponse(
    val data: List<ApiNewsItem>
)

data class SimilarNewsResponse(
    val data: List<NewsItem>
)
