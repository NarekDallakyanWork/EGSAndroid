package egs.domain.usecase.movies

import egs.domain.base.BaseUseCase
import egs.domain.model.State
import egs.domain.model.moves.MovieItemModel

interface GetMoviesListUseCase : BaseUseCase<Map<String, String>, List<MovieItemModel>> {

    override suspend operator fun invoke(param: Map<String, String>): State<List<MovieItemModel>>
}