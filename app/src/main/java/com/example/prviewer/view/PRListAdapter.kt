package com.example.prviewer.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.prviewer.databinding.CardviewDesignBinding
import com.example.prviewer.model.PullRequest

class PRListAdapter(
    private val context: Context, private val pullRequests: ArrayList<PullRequest>
) : RecyclerView.Adapter<PRListAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return pullRequests.size
    }

    inner class ViewHolder(private val binding: CardviewDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(pullRequest: PullRequest) {
            binding.textView.text = pullRequest.toString()
            Glide.with(context)
                .load(pullRequest.user.imageUrl)
                .into(binding.imageView)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val launch = pullRequests[position]
        holder.bind(launch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardviewDesignBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}