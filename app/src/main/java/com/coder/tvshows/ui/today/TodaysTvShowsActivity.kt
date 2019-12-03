package com.coder.tvshows.ui.today

import android.os.Bundle
import com.coder.tvshows.R
import com.coder.tvshows.data.network.model.Episode
import com.coder.tvshows.ui.base.BaseActivity
import com.coder.tvshows.ui.today.details.TodaysShowDetailsFragment
import com.coder.tvshows.ui.today.list.TodaysShowListFragment

class TodaysTvShowsActivity : BaseActivity(), TodaysShowListFragment.ItemClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showList()
    }

    private fun showList() {
        val tag = TodaysShowListFragment.TAG
        val fragment = TodaysShowListFragment.newInstance()

        if (supportFragmentManager.findFragmentByTag(tag) != null) return

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment, tag)
            .commitAllowingStateLoss()
    }

    override fun onItemClick(episode: Episode) {
        showDetails(episode)
    }

    private fun showDetails(episode: Episode) {
        val tag = TodaysShowDetailsFragment.TAG
        val fragment = TodaysShowListFragment.newInstance()
    }
}
