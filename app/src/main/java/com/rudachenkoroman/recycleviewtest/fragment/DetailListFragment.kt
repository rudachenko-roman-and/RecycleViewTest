package com.rudachenkoroman.recycleviewtest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rudachenkoroman.recycleviewtest.data.ContentModel
import com.rudachenkoroman.recycleviewtest.databinding.FragmentDetailListBinding

class DetailListFragment : Fragment() {

    private var _binding: FragmentDetailListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = requireArguments().getString("key1")
        val name = requireArguments().getString("key2")
        val detail = requireArguments().getString("key3")
        binding.newsId.text = id
        binding.newsNameDetail.text = name
        binding.newsDetailDetail.text = detail
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        fun newInstance(model: ContentModel): DetailListFragment{
            return DetailListFragment().apply {
                arguments = Bundle().also {
                    it.putString("key1", model.id.toString())
                    it.putString("key2", model.name)
                    it.putString("key3" , model.detail)
                }
            }
        }
    }
}