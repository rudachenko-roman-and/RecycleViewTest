package com.rudachenkoroman.recycleviewtest.util

import androidx.recyclerview.widget.DiffUtil
import com.rudachenkoroman.recycleviewtest.data.ContentModel

object ContentDiffUtil : DiffUtil.ItemCallback<ContentModel>() {
    override fun areItemsTheSame(oldItem: ContentModel, newItem: ContentModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ContentModel, newItem: ContentModel): Boolean {
        return oldItem == newItem
    }
}