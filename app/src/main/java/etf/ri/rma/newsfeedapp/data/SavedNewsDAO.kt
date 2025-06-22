package etf.ri.rma.newsfeedapp.data

import androidx.room.*
import etf.ri.rma.newsfeedapp.model.News
import etf.ri.rma.newsfeedapp.model.NewsItem
import etf.ri.rma.newsfeedapp.model.NewsTag
import etf.ri.rma.newsfeedapp.model.NewsWithTags
import etf.ri.rma.newsfeedapp.model.Tag
import etf.ri.rma.newsfeedapp.model.toNews


@Dao
interface SavedNewsDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNews(news: News): Long

    suspend fun saveNews(newsItem: NewsItem): Boolean {
        val news = newsItem.toNews()
        val id = insertNews(news)
        return id != -1L
    }

    @Query("SELECT * FROM News WHERE uuid = :uuid LIMIT 1")
    suspend fun getNewsByUuid(uuid: String): News?

    @Transaction
    @Query("SELECT * FROM News WHERE category = :category")
    suspend fun getNewsWithCategoryWithTags(category: String): List<NewsWithTags>

    @Transaction
    @Query("SELECT * FROM News")
    suspend fun getAllNewsWithTags(): List<NewsWithTags>

    @Query("SELECT * FROM News")
    suspend fun allNews(): List<NewsWithTags>

    @Query("SELECT * FROM News WHERE category = :category")
    suspend fun getNewsWithCategory(category: String): List<News>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTag(tag: Tag): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewsTag(newsTag: NewsTag)

    @Transaction
    suspend fun addTags(tagValues: List<String>, newsId: Int) {
        for (value in tagValues) {
            val tagId = insertTag(Tag(value = value)).let {
                if (it == -1L) getTagIdByValue(value) else it
            }
            insertNewsTag(NewsTag(newsId = newsId, tagId = tagId.toInt()))
        }
    }

    @Query("SELECT * FROM Tags")
    suspend fun getAllTags(): List<Tag>

    @Query("SELECT id FROM Tags WHERE value = :value")
    suspend fun getTagIdByValue(value: String): Int

    @Transaction
    @Query("""
        SELECT t.value FROM Tags t
        INNER JOIN NewsTags nt ON nt.tagId = t.id
        WHERE nt.newsId = :newsId
    """)
    suspend fun getTags(newsId: Int): List<String>

    @Transaction
    @Query("""
        SELECT * FROM News
        WHERE id IN (
            SELECT newsId FROM NewsTags
            WHERE tagId IN (
                SELECT id FROM Tags WHERE value IN (:tagValues)
            )
        )
    """)
    suspend fun getSimilarNews(tagValues: List<String>): List<News>
}

