package egs.android.ui.movies.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import egs.android.R
import egs.android.ui.movies.view.viewholder.MovieViewHolder
import egs.domain.model.moves.MovieItemModel
import javax.inject.Inject

class MoviesListAdapter @Inject constructor() :
    PagingDataAdapter<MovieItemModel, MovieViewHolder>(DIFF_CALLBACK) {

    private var onItemClickListener: (item: MovieItemModel) -> Unit = {}
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieItem = getItem(position)
        holder.onBind(movieItem, onItemClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.vh_movie_item, parent, false)
        return MovieViewHolder(view)
    }

    /**
     *  Adding Item click listener
     */
    fun addOnItemClickListener(onItemClickListener: (item: MovieItemModel) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }


    companion object {
        val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<MovieItemModel>() {
            override fun areItemsTheSame(
                oldConcert: MovieItemModel,
                newConcert: MovieItemModel
            ) = oldConcert.hashCode() == newConcert.hashCode()

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldConcert: MovieItemModel,
                newConcert: MovieItemModel
            ) = oldConcert == newConcert
        }
    }
}