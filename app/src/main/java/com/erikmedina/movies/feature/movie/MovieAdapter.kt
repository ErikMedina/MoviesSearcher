package com.erikmedina.movies.feature.movie

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.erikmedina.movies.R

class MovieAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(movie: Movie)
    }

    private var itemViews = emptyList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = itemViews.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = itemViews[position].title
        holder.poster.text = itemViews[position].poster
        holder.year.text = itemViews[position].years
        holder.bind(itemViews[position], listener)
    }

    fun setItemViews(movies: List<Movie>) {
        this.itemViews = movies
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.title)
        var poster: TextView = itemView.findViewById(R.id.tvPoster)
        var year: TextView = itemView.findViewById(R.id.tvYear)

        fun bind(movie: Movie, listener: OnItemClickListener) {
            itemView.setOnClickListener {
                listener.onItemClick(movie)
            }
        }
    }
}
