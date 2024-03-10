package com.example.mercadito.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mercadito.databinding.FragmentHomeBinding
import com.example.mercadito.ui.fragments.adapters.NewsAdapter
import com.example.mercadito.vo.NewsVO

class NewsFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val recyclerView = binding.newsRecyclerView
        val dataList = initListNews() // Obtener la lista de noticias

        val adapter = NewsAdapter(dataList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    private fun initListNews():List<NewsVO> {
        return listOf<NewsVO>(
            NewsVO("La papa subio","papita","la papa esta a 5k"),
            NewsVO("La papa subio","papita","la papa esta a 5k"),
            NewsVO("La papa subio","papita","la papa esta a 5k"),
            NewsVO("La papa subio","papita","la papa esta a 5k"),
            NewsVO("La papa subio","papita","la papa esta a 5k"),
            NewsVO("La papa subio","papita","la papa esta a 5k"),
            NewsVO("La papa subio","papita","la papa esta a 5k"),
            NewsVO("La papa subio","papita","la papa esta a 5k"),
            NewsVO("La papa subio","papita","la papa esta a 5k"),
            NewsVO("La papa subio","papita","la papa esta a 5k"),
            NewsVO("La papa subio","papita","la papa esta a 5k"),
            NewsVO("La papa subio","papita","la papa esta a 5k")
        )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}