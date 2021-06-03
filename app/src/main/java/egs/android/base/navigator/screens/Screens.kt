package egs.android.base.navigator.screens

import androidx.fragment.app.Fragment
import egs.android.ui.movies.view.fragment.MovieDetailFragment
import egs.android.ui.movies.view.fragment.MoviesListFragment

/**
 * Available screens.
 */
enum class Screens {

    MOVIES_LIST {
        override val fragmentClass = MoviesListFragment::class.java
    },
    MOVIE_DETAIL{
        override val fragmentClass = MovieDetailFragment::class.java
    };

    abstract val fragmentClass: Class<out Fragment>
}