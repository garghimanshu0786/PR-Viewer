package com.example.prviewer.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.prviewer.R
import com.example.prviewer.databinding.FragmentPrlistBinding
import com.example.prviewer.model.PullRequest
import com.example.prviewer.viewmodel.PRListViewModel

class PRListFragment : Fragment(R.layout.fragment_prlist) {
    private val viewModel: PRListViewModel by lazy {
        ViewModelProvider(this)[PRListViewModel::class.java]
    }
    private var pullRequests: ArrayList<PullRequest> = ArrayList()

    private var _binding: FragmentPrlistBinding? = null
    private val binding
        get() = requireNotNull(_binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPrlistBinding.bind(view)

        setupAdapter()
    }

    private fun setupAdapter() {
        val adapter = PRListAdapter(requireContext(), pullRequests)
        viewModel.pullRequests.observe(viewLifecycleOwner) {
            pullRequests.addAll(it as ArrayList<PullRequest>)
            adapter.notifyDataSetChanged()
        }
        binding.recyclerview.apply {
            this.adapter = adapter
            this.setHasFixedSize(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}