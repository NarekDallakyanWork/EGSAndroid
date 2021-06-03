package egs.android.ui.movies.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import coil.load
import egs.android.R
import egs.android.base.ext.toast
import egs.android.base.fragment.BaseFragment
import egs.domain.model.moves.MovieItemModel


class MovieDetailFragment : BaseFragment(R.layout.fragment_movie_detail) {

    private lateinit var movieItemModel: MovieItemModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // getting movie model from argument
        getArgumentData()
        // Adding data to corresponding views
        addContent()
    }

    private fun addContent() {
        if (!this::movieItemModel.isInitialized) {
            toast("Can't show Movie")
            return
        }

        // Show cover image
        requireView().findViewById<ImageView>(R.id.movieCoverImage).apply {
            load("https://image.tmdb.org/t/p/w500/${movieItemModel.backdropPath}")
        }
        // Show overview text
        requireView().findViewById<TextView>(R.id.movieOverViewText).apply {
            text = movieItemModel.overview
        }
    }

    private fun getArgumentData() {
        if (arguments == null) return
        movieItemModel = requireArguments().getSerializable("movie") as MovieItemModel
    }
}