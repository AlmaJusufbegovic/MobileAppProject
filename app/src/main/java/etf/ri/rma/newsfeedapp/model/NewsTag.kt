package etf.ri.rma.newsfeedapp.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "NewsTags",
    primaryKeys = ["newsId", "tagId"],
    foreignKeys = [
        ForeignKey(
            entity = News::class,
            parentColumns = ["id"],
            childColumns = ["newsId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Tag::class,
            parentColumns = ["id"],
            childColumns = ["tagId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["newsId"]), Index(value = ["tagId"])]
)
data class NewsTag(
    val newsId: Int,
    val tagId: Int
)

