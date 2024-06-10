package com.rudachenkoroman.recycleviewtest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.rudachenkoroman.recycleviewtest.data.ContentModel
import com.rudachenkoroman.recycleviewtest.databinding.ContentItemBinding
import com.rudachenkoroman.recycleviewtest.util.ContentDiffUtil


class ContentAdapter(
    private val onClickAction: (ContentModel) -> Unit,
) : ListAdapter<ContentModel, ContentAdapter.ContentViewHolder>(
    ContentDiffUtil
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContentItemBinding.inflate(inflater,parent,false)
        val holder = ContentViewHolder(binding)
        binding.root.setOnClickListener {
            val model = getItem(holder.adapterPosition)
            onClickAction(model)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
    }

    class ContentViewHolder(private val binding: ContentItemBinding) : ViewHolder(binding.root) {
        fun bind(model: ContentModel) {
            binding.newsName.text = model.name
            binding.newsDetail.text = model.detail
        }
    }
}