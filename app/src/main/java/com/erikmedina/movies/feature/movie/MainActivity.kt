package com.erikmedina.movies.feature.movie

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.erikmedina.movies.R
import com.erikmedina.movies.core.platform.BaseActivity
import com.erikmedina.movies.data.local.model.Item
import com.erikmedina.movies.util.Constant
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var context: Context

    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        context = this
        initializeRecycler()
        initializeSearchBox()
    }

    override fun getLayoutId() = R.layout.activity_main

    private fun initializeRecycler() {
        adapter = ItemAdapter(object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(item: Item) {
                Log.i(TAG, "[onItemClick] item selected: ${item.title}")
                presenter.onItemSelected(item.id)
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

    override fun setItemViews(items: List<Item>) {
        adapter.setItemViews(items)
    }

    override fun startItemDetailActivity(item: Item) {
        val intent = Intent(context, ItemDetailActivity::class.java)
        intent.putExtra(Constant.EXTRA_ITEM, item)
        startActivity(intent)
    }

    override fun showError(error: String) {
        val rootView = window.decorView.findViewById<View>(android.R.id.content)
        Snackbar.make(rootView, error, Snackbar.LENGTH_SHORT).show()
    }

    override fun showLoading(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName.toString()
    }
}