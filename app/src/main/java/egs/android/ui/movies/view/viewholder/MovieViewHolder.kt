package egs.android.ui.movies.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import egs.android.R
import egs.android.base.ext.convertDatePattern
import egs.domain.model.moves.MovieItemModel

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(movieItem: MovieItemModel?, onItemClickListener: (item: MovieItemModel) -> Unit) {
        // Setting data to views
        addDataToView(movieItem)
        // Listening item clicked
        itemView.setOnClickListener {
            movieItem?.let {
                onItemClickListener.invoke(it)
            }
        }
    }

    private fun addDataToView(movieItem: MovieItemModel?) {

        // Loading movie thumbnail image
        itemView.findViewById<ImageView>(R.id.movieThumbnailImage).apply {
            load("https://image.tmdb.org/t/p/w500/${movieItem?.backdropPath ?: ""}")
        }
        // Setting movie Title to title text view
        itemView.findViewById<TextView>(R.id.movieTitleText).apply {
            text = movieItem?.title ?: ""
        }
        // Setting movie Year to year text view
        itemView.findViewById<TextView>(R.id.movieYearText).apply {
            text = movieItem?.releaseDate?.convertDatePattern("yyyy-MM-dd", "yyyy") ?: ""
        }
        // Setting movie Rate to rate text view
        itemView.findViewById<TextView>(R.id.movieRateText).apply {
            text = "★ ${movieItem?.voteAverage ?: 0} (${movieItem?.voteCount ?: 0})"
        }
    }
}