package com.example.mercadito.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mercadito.databinding.FragmentCategoriesBinding
import com.example.mercadito.ui.fragments.adapters.CategoryAdapter
import com.example.mercadito.vo.CategoryVO

class CategoryFragment:Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val recyclerView = binding.categoriesRecyclerView
        val dataList = initListItems() // Obtener la lista de noticias
        val adapter = CategoryAdapter(dataList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    private fun initListItems():List<CategoryVO> {
        return listOf(
            CategoryVO(1,"tuberculos","casas del suelo"),
            CategoryVO(2,"fruta","casas de arboles"),
            CategoryVO(3,"lacteos","casas de vaca"),
            CategoryVO(4,"carnes","casas de vaca muerto"),
            CategoryVO(5,"pollos","casas de aves"),
            CategoryVO(6,"huevos","casas de popo de aves"),
            CategoryVO(7,"galgerias","casas de paquete"),
            CategoryVO(8,"jugos","casas de tomar"),
            CategoryVO(9,"embutidos","casas molidas"),
            CategoryVO(10,"mascotas","casas de perros"),
            CategoryVO(11,"aseo","casas de limpiar"),
            CategoryVO(12,"otros","casas de fumar")
        )

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}