package com.example.mercadito.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mercadito.databinding.FragmentHistoricBinding
import com.example.mercadito.ui.fragments.adapters.ShopListAdapter
import com.example.mercadito.vo.ItemVO
import com.example.mercadito.vo.ShopListVO

class HistoricFragment:Fragment() {

    private var _binding: FragmentHistoricBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoricBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val recyclerView = binding.listRecyclerView
        val dataList = initListShop() // Obtener la lista de noticias
        val adapter = ShopListAdapter(requireContext(),dataList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    private fun initListShop():List<ShopListVO> {
        return listOf(
            ShopListVO(1,"mercado del 15",initListItems()),
            ShopListVO(2,"mercado del 30",initListItems()),
            ShopListVO(3,"mercadito",initListItems()),
            ShopListVO(4,"mercao del 15",initListItems()),
        )

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