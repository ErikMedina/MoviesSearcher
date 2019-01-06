package com.erikmedina.movies.feature.movie

import android.os.Bundle
import com.erikmedina.movies.R
import com.erikmedina.movies.core.platform.BaseActivity
import com.erikmedina.movies.core.util.Constant
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetailActivity : BaseActivity() {

    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movie = intent.getSerializableExtra(Constant.EXTRA_ITEM) as Movie
        initializeItemDetail()
    }

    private fun initializeItemDetail() {
        tvTitle.text = movie.title
        tvPoster.text = movie.poster
        tvBody.text = movie.plot
        tvYear.text = movie.years
    }

    override fun getLayoutId() = R.layout.activity_item_detail
}
