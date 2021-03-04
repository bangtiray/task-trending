package com.bangtiray.ghtrend.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bangtiray.ghtrend.R
import com.bangtiray.ghtrend.databinding.ActivityMainBinding
import com.bangtiray.mylibrary.data.source.Resource
import com.bangtiray.mylibrary.ui.TrendAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@Suppress("DEPRECATION")
@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private lateinit var binding: ActivityMainBinding
    private val hViewModel: ViewModel by viewModels()
    private lateinit var tAdapter: TrendAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.swipeRefreshLayout.setOnRefreshListener(this)
        setContentView(binding.root)
        setList()
        startLoading()
    }

    private fun startLoading() {
        binding.shimmerViewContainer.visibility = View.VISIBLE
        binding.shimmerViewContainer.startShimmer()
        if (binding.swipeRefreshLayout.isRefreshing) return
        binding.swipeRefreshLayout.isRefreshing = true
        binding.recyclerView.visibility=View.GONE
        loadData("typescript", "daily")
    }

    private fun stopLoading() {
        if (binding.swipeRefreshLayout.isRefreshing) binding.swipeRefreshLayout.isRefreshing = false
        binding.shimmerViewContainer.stopShimmer()
        binding.shimmerViewContainer.visibility = View.GONE
    }

    private fun loadFailed() {
        stopLoading()
        Snackbar.make(
            binding.rootLayout,
            resources.getString(R.string.error_load),
            Snackbar.LENGTH_INDEFINITE
        ).setAction(resources.getString(R.string.refresh)) {
            startLoading()
        }.show()
    }

    private fun setList() {
        tAdapter = TrendAdapter()
        tAdapter.onItemClick = { resp ->
            Log.i("Click ", resp.toString())
        }

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        val dividerItemDecoration = DividerItemDecoration(
            binding.recyclerView.context,
            linearLayoutManager.orientation
        )
        with(binding.recyclerView) {
            layoutManager = linearLayoutManager
            addItemDecoration(dividerItemDecoration)
            setHasFixedSize(true)
            adapter = tAdapter
        }
    }

    private fun loadData(s: String = "typescript", s1: String = "daily") {

        hViewModel.getAllTrend(s, s1).observe(this) { resp ->

            when (resp) {
                is Resource.Loading -> startLoading()
                is Resource.Success -> {
                    Log.d("Resource :", resp.toString())
                    binding.recyclerView.visibility=View.VISIBLE
                    stopLoading()
                    tAdapter.setData(resp.data)
                }
                is Resource.Error -> {
                    stopLoading()
                    loadFailed()
                }
            }
        }


    }

    override fun onRefresh() {
        stopLoading()
        startLoading()
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerViewContainer.startShimmer()
        startLoading()
    }

    override fun onPause() {
        binding.shimmerViewContainer.stopShimmer()
        stopLoading()
        super.onPause()

    }
}