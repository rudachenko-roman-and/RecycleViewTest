package com.rudachenkoroman.recycleviewtest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rudachenkoroman.recycleviewtest.R
import com.rudachenkoroman.recycleviewtest.adapter.ContentAdapter
import com.rudachenkoroman.recycleviewtest.data.ContentModel
import com.rudachenkoroman.recycleviewtest.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val contentAdapter = ContentAdapter(onClickAction = {model -> onNewsClick(model)})

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = contentAdapter
        contentAdapter.submitList(List(100) {
            ContentModel(it , "Name News $it ","Detail News $it")
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onNewsClick(model: ContentModel) {
        Toast.makeText(requireActivity(),"You have selected ${model.id} news", Toast.LENGTH_SHORT).show()
        replaceFragment(model)
    }

    private fun replaceFragment(model: ContentModel){
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view,DetailListFragment.newInstance(model))
            .addToBackStack(null)
            .setReorderingAllowed(true)
            .commit()
    }
}