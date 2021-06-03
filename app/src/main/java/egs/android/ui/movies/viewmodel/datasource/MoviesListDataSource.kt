package egs.android.ui.movies.viewmodel.datasource

import androidx.paging.PagingSource
import egs.domain.model.moves.MovieItemModel
import egs.domain.model.onFailure
import egs.domain.model.onSuccess
import egs.domain.usecase.movies.GetMoviesListUseCase

class MoviesListDataSource(private val moviesListUseCase: GetMoviesListUseCase) :
    PagingSource<Int, MovieItemModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieItemModel> {
        // generate pagination page value
        val page = params.key ?: 1
        val queryMap = LinkedHashMap<String, String>()
        queryMap["page"] = page.toString()
        queryMap["language"] = "en-US"
        queryMap["api_key"] = "ec5cd774856614504f1a84ab00e5a6cf"
        var result: List<MovieItemModel> = ArrayList()
        moviesListUseCase(queryMap)
            .onSuccess {
                result = it
            }
            .onFailure {
                return LoadResult.Error(it.throwable)
            }
        // generate pagination next page value
        val nextPage: Int? = if (result.isNotEmpty()) page + 1 else null
        val prevPage: Int? = if (page == 0) null else page - 1
        // notify data to recycler view
        return LoadResult.Page(
            data = result,
            prevKey = prevPage,
            nextKey = nextPage
        )
    }
}