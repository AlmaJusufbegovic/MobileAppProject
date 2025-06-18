package etf.ri.rma.newsfeedapp.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tags")
data class TagEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val value: String
)
