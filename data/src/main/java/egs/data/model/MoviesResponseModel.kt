package egs.data.model


import com.google.gson.annotations.SerializedName
import egs.domain.model.moves.MovieItemModel

data class MoviesResponseModel(
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var results: List<MovieItemModel>?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var totalResults: Int?
)