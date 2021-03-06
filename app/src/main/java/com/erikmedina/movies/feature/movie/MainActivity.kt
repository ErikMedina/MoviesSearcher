package com.erikmedina.movies.feature.movie

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.erikmedina.movies.R
import com.erikmedina.movies.core.platform.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var context: Context

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        context = this
        initializeRecycler()
        initializeSearchBox()
    }

    override fun getLayoutId() = R.layout.activity_main

    private fun initializeRecycler() {
        adapter = MovieAdapter(object : MovieAdapter.OnItemClickListener {
            override fun onItemClick(movie: Movie) {
                Log.i(TAG, "[onItemClick] item selected: ${movie.title}")
                presenter.onItemSelected(movie.id)
            }
        })
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
    }

    private fun initializeSearchBox() {
        etMovies.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                presenter.getContentList(s.toString())
            }
        })
    }

    override fun onResume() {
        super.onResume()
        presenter.takeView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.dropView()
    }

    override fun setItemViews(movies: List<Movie>) {
        adapter.setItemViews(movies)
    }

    override fun startItemDetailActivity(movie: Movie) {
        val intent = Intent(context, MovieDetailActivity::class.java)
        intent.putExtra(EXTRA_MOVIE, movie)
        startActivity(intent)
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName.toString()
        const val EXTRA_MOVIE = "extra_movie"
    }
}
