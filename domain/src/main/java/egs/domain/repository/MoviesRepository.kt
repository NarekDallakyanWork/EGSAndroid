package egs.domain.repository

import egs.domain.model.State
import egs.domain.model.moves.MovieItemModel

interface MoviesRepository {
    suspend fun getMoviesList(param: Map<String, String>): State<List<MovieItemModel>>
}