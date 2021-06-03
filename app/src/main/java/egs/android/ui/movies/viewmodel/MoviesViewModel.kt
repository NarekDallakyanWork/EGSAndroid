package egs.android.ui.movies.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import egs.android.ui.movies.viewmodel.datasource.MoviesListDataSource
import egs.domain.model.moves.MovieItemModel
import egs.domain.usecase.movies.GetMoviesListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesListUseCase: GetMoviesListUseCase
) : ViewModel() {

    val moviesListPagingLiveData =
        Pager(PagingConfig(pageSize = 20)) {
            MoviesListDataSource(moviesListUseCase)
        }.flow.cachedIn(CoroutineScope(Dispatchers.IO))
            .asLiveData()
            .let { it as MutableLiveData<PagingData<MovieItemModel>> }
}