package com.erikmedina.article.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.erikmedina.article.MyApplication
import com.erikmedina.article.R
import com.erikmedina.article.data.local.model.Item
import com.erikmedina.article.di.component.DaggerMainComponent
import com.erikmedina.article.di.module.MainModule
import com.erikmedina.article.presentation.BaseActivity
import com.erikmedina.article.presentation.itemdetail.ItemDetailActivity
import com.erikmedina.article.presentation.main.adapter.ItemAdapter
import com.erikmedina.article.util.Constant
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {
    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var context: Context

    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        initializeRecycler()
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

    override fun initializeDependencyInjector() {
        val component = DaggerMainComponent.builder()
                .myApplicationComponent((application as MyApplication).getComponent())
                .mainModule(MainModule())
                .build()
        component.inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.takeView(this)
        presenter.getContentList()
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
