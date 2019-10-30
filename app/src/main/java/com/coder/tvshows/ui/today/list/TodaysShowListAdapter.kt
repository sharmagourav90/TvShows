package com.coder.tvshows.ui.today.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.coder.tvshows.R
import com.coder.tvshows.data.network.model.Episode
import com.coder.tvshows.databinding.TodaysShowListItemBinding
import com.coder.tvshows.util.Constants

class TodaysShowListAdapter(private val itemClick: ItemClick) :
    ListAdapter<Episode, TodaysShowListAdapter.ShowViewHolder>(ShowDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<TodaysShowListItemBinding>(
            inflater,
            R.layout.todays_show_list_item,
            parent,
            false
        )
        return ShowViewHolder(binding, itemClick)
    }

    interface ItemClick {
        fun onItemClick(episode: Episode)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ShowViewHolder(val binding: TodaysShowListItemBinding, val itemClick: ItemClick) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: Episode) {
            binding.imageType = Constants.IMAGE_TYPE_MEDIUM
            binding.episode = episode
        }
    }

    private class ShowDiffUtilCallback : DiffUtil.ItemCallback<Episode>() {
        override fun areContentsTheSame(oldItem: Episode, newItem: Episode) =
            (oldItem.id == newItem.id)

        override fun areItemsTheSame(oldItem: Episode, newItem: Episode) =
            (oldItem == newItem)
    }
}