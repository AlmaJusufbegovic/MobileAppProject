package etf.ri.rma.newsfeedapp.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class NewsWithTags(
    @Embedded val news: News,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = NewsTag::class,
            parentColumn = "newsId",
            entityColumn = "tagId"
        )
    )
    val imageTags: List<Tag>
)
