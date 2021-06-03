package egs.data.repository

import egs.data.api.ApiService
import egs.domain.model.State
import egs.domain.model.Success
import egs.domain.model.moves.MovieItemModel
import egs.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    MoviesRepository {
    override suspend fun getMoviesList(param: Map<String, String>): State<List<MovieItemModel>> {
        // Getting Server response
        val moviesResponse = apiService.getMoviesList(param)
        // Converting server response model to Movies Item list
        return Success(moviesResponse.body()?.results ?: listOf())
    }
}