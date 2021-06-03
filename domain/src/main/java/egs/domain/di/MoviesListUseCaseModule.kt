package egs.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import egs.domain.repository.MoviesRepository
import egs.domain.usecase.movies.GetMoviesListUseCase
import egs.domain.usecase.movies.GetMoviesListUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
class MoviesListUseCaseModule {

    @Provides
    fun bindMoviesListUseCase(repository: MoviesRepository): GetMoviesListUseCase {
        return GetMoviesListUseCaseImpl(repository)
    }
}
