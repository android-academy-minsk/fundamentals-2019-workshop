package com.androidacademy.workshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.androidacademy.workshop.R
import com.androidacademy.workshop.data.Movie

class MoviesAdapter(
    private val clickListener: (position: Int) -> Unit
) : ListAdapter<Movie, MoviesAdapter.ViewHolder>(MovieDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            inflater.inflate(
                R.layout.item_movie,
                parent,
                false
            ),
            clickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        itemView: View,
        listener: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val poster: ImageView = itemView.findViewById(R.id.poster)
        private val title: TextView = itemView.findViewById(R.id.title)
        private val overview: TextView = itemView.findViewById(R.id.overview)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener(position)
                }
            }
        }

        fun bind(movie: Movie) {
            poster.load(movie.posterUrl)
            title.text = movie.title
            overview.text = movie.overview
        }
    }
}