package etf.ri.rma.newsfeedapp.model

data class ImagaResponse(
    val result: Result
)

data class Result(
    val tags: List<Tag>
)

data class Tag(
    val tag: Map<String, String>
)
