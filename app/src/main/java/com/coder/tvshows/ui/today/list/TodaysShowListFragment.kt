package com.coder.tvshows.ui.today.list

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.coder.tvshows.R
import com.coder.tvshows.data.Resource
import com.coder.tvshows.data.network.model.Episode
import com.coder.tvshows.di.TvViewModelFactory
import com.coder.tvshows.ui.base.BaseFragment
import com.coder.tvshows.util.GridItemDecoration
import com.coder.tvshows.util.NoConnectivityException
import com.coder.tvshows.util.extensions.showToast
import kotlinx.android.synthetic.main.progress_bar.*
import kotlinx.android.synthetic.main.todays_show_list.*
import javax.inject.Inject

class TodaysShowListFragment : BaseFragment(), TodaysShowListAdapter.ItemClick {
    private lateinit var itemClick: ItemClick

    @Inject
    lateinit var factory: TvViewModelFactory

    override val layoutId by lazy { R.layout.todays_show_list }
    override val viewModelClass by lazy { TodaysShowListViewModel::class.java }
    override fun provideViewModelFactory() = factory
    val mViewModel: TodaysShowListViewModel by lazy { baseViewModel as TodaysShowListViewModel }

    private val mAdapter: TodaysShowListAdapter by lazy { TodaysShowListAdapter(this) }
    private var mNumItems = 2

    companion object {
        val TAG = "TodaysShowListFragment"
        fun newInstance() = TodaysShowListFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        itemClick = parentActivity as ItemClick
        if (activity?.getResources()?.getConfiguration()?.orientation == Configuration.ORIENTATION_PORTRAIT) {
            mNumItems = 2
        } else
            mNumItems = 3
    }

    override fun initUI() {
        rv_todays_show.layoutManager = GridLayoutManager(activity, mNumItems)
        rv_todays_show.adapter = mAdapter
        rv_todays_show.setHasFixedSize(true)
        val spacing = resources.getDimensionPixelSize(R.dimen.show_grid_spacing)
        rv_todays_show.addItemDecoration(GridItemDecoration(spacing, mNumItems))
    }

    override fun setUpObservers() {
        mViewModel.todaysShowList.observe(this, Observer { resource ->
            when (resource) {
                is Resource.Loading -> showLoading()
                is Resource.Success -> {
                    hideLoading()
                    mAdapter.submitList(resource.data)
                }
                is Resource.Failure -> {
                    hideLoading()
                    showError(resource.throwable)
                }
            }
        })
    }

    private fun showLoading() {
        progress_bar_container.visibility = View.VISIBLE
        rv_todays_show.visibility = View.GONE
    }

    private fun hideLoading() {
        progress_bar_container.visibility = View.GONE
        rv_todays_show.visibility = View.VISIBLE
    }

    private fun showError(error: Throwable) {
        when (error) {
            is NoConnectivityException -> resources.getString(R.string.no_network).showToast(
                parentActivity
            )
        }
    }

    interface ItemClick {
        fun onItemClick(episode: Episode)
    }

    override fun onItemClick(episode: Episode) {
        itemClick.onItemClick(episode)
    }
}