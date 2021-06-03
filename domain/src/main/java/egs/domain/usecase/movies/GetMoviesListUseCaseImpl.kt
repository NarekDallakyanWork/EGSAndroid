package egs.domain.usecase.movies

import egs.domain.repository.MoviesRepository
import javax.inject.Inject

class GetMoviesListUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    GetMoviesListUseCase {
    override suspend operator fun invoke(param: Map<String, String>) =
        moviesRepository.getMoviesList(param)
}