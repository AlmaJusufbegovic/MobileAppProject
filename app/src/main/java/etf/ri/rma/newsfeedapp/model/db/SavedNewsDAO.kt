package etf.ri.rma.newsfeedapp.model.db

import androidx.room.*
import etf.ri.rma.newsfeedapp.model.NewsItem
import etf.ri.rma.newsfeedapp.model.toEntity

@Dao
interface SavedNewsDAO {

    @Query("SELECT * FROM News WHERE uuid = :uuid LIMIT 1")
    suspend fun getNewsByUuid(uuid: String): NewsEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNews(news: NewsEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTag(tag: TagEntity): Long

    @Query("SELECT * FROM Tags WHERE value = :value LIMIT 1")
    suspend fun getTagByValue(value: String): TagEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewsTagCrossRef(ref: NewsTagCrossRef)

    @Transaction
    suspend fun saveNews(newsItem: NewsItem): Boolean {
        val existing = getNewsByUuid(newsItem.uuid)
        if (existing != null) return false
        insertNews(newsItem.toEntity())
        return true
    }

    @Transaction
    suspend fun addTags(tags: List<String>, newsId: Int): Int {
        var newTags = 0
        for (tag in tags) {
            val existing = getTagByValue(tag)
            val tagId = existing?.id ?: run {
                val newId = insertTag(TagEntity(value = tag)).toInt()
                if (newId != -1) newTags++
                newId
            }
            insertNewsTagCrossRef(NewsTagCrossRef(newsId, tagId))
        }
        return newTags
    }

    @Transaction
    @Query("SELECT * FROM News")
    suspend fun getAllNewsWithTags(): List<NewsWithTags>

    @Transaction
    @Query("SELECT * FROM News WHERE category = :category")
    suspend fun getNewsWithCategoryWithTags(category: String): List<NewsWithTags>

    @Transaction
    @Query("SELECT * FROM News WHERE id = :newsId")
    suspend fun getNewsWithTags(newsId: Int): NewsWithTags?

    suspend fun getTags(newsId: Int): List<String> {
        return getNewsWithTags(newsId)?.tags?.map { it.value } ?: emptyList()
    }

    @Transaction
    @Query("""
        SELECT DISTINCT News.* FROM News
        INNER JOIN NewsTags ON News.id = NewsTags.newsId
        INNER JOIN Tags ON Tags.id = NewsTags.tagId
        WHERE Tags.value IN (:tags)
        ORDER BY publishedDate DESC
    """)
    suspend fun getSimilarNewsWithTags(tags: List<String>): List<NewsWithTags>
}
