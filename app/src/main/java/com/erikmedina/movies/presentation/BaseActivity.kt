package com.erikmedina.movies.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initializeDependencyInjector()
    }

    abstract fun getLayoutId(): Int

    protected abstract fun initializeDependencyInjector()
}
