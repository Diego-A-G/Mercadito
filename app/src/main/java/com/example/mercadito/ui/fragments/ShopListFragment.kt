package com.example.mercadito.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mercadito.databinding.FragmentShoplistBinding
import com.example.mercadito.ui.fragments.adapters.ArticleAdapter
import com.example.mercadito.vo.ItemVO

class ShopListFragment:Fragment() {

    private var _binding: FragmentShoplistBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoplistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val recyclerView = binding.itemsRecyclerView
        val dataList = initListItems() // Obtener la lista de noticias
        val adapter = ArticleAdapter(dataList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    private fun initListItems():List<ItemVO> {
        return listOf(
            ItemVO(1,"papas",5000.toDouble(),"mayooonesa",1,1),
            ItemVO(1,"papas",5000.toDouble(),"tomate",1,1),
            ItemVO(1,"papas",5000.toDouble(),"ajo",1,1),
            ItemVO(1,"papas",5000.toDouble(),"mayooonesa",1,1),
            ItemVO(1,"papas",5000.toDouble(),"tomate",1,1),
            ItemVO(1,"papas",5000.toDouble(),"ajo",1,1),
            ItemVO(1,"papas",5000.toDouble(),"mayooonesa",1,1),
            ItemVO(1,"papas",5000.toDouble(),"tomate",1,1),
            ItemVO(1,"papas",5000.toDouble(),"ajo",1,1),
            ItemVO(1,"papas",5000.toDouble(),"mayooonesa",1,1),
            ItemVO(1,"papas",5000.toDouble(),"tomate",1,1),
            ItemVO(1,"papas",5000.toDouble(),"ajo",1,1),
            ItemVO(1,"papas",5000.toDouble(),"mayooonesa",1,1),
            ItemVO(1,"papas",5000.toDouble(),"tomate",1,1),
            ItemVO(1,"papas",5000.toDouble(),"ajo",1,1),
        )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}