package com.bogdanbele.planday.model

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bogdanbele.planday.databinding.ComponentGuideBinding

class GuidesAdapter(private val items: List<Guide>) : RecyclerView.Adapter<GuidesAdapter.GuideViewHolder>() {
    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(p0: ViewGroup, position: Int): GuideViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        val binding = ComponentGuideBinding.inflate(inflater)
        return GuideViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return items.size
    }


    inner class GuideViewHolder(val binding: ComponentGuideBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Guide) {
            binding.guide = item
            binding.executePendingBindings()
        }
    }
}