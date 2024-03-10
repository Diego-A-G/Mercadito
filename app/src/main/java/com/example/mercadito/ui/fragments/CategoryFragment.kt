package com.example.mercadito.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mercadito.R
import com.example.mercadito.databinding.FragmentCategoriesBinding
import com.example.mercadito.ui.fragments.adapters.CategoryAdapter
import com.example.mercadito.ui.managers.CategoryViewModel
import com.example.mercadito.ui.managers.CategoryViewModelFactory
import com.example.mercadito.vo.CategoryVO

class CategoryFragment:Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryViewModel: CategoryViewModel

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
        initViewModel()
        initAdapter()
        initButtons()
    }

    private fun initViewModel() {
        val factory = CategoryViewModelFactory(requireContext())
        categoryViewModel = ViewModelProvider(this,factory)[CategoryViewModel::class.java]
    }

    private fun initButtons() {
        binding.addCategoryFab.setOnClickListener {
            showDialogAddCategory()
        }
    }

    private fun showDialogAddCategory() {
        val dialogView = layoutInflater.inflate(R.layout.add_item_category, null)
        val dialogButtonAdd = dialogView.findViewById<Button>(R.id.buttonAccept)
        val dialogButtonClose = dialogView.findViewById<Button>(R.id.buttonCancel)
        val dialogName = dialogView.findViewById<EditText>(R.id.editTextName)
        val dialogDescription = dialogView.findViewById<EditText>(R.id.editTextDescription)

        // Crea y muestra el diálogo
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()

        // Configura el botón de cerrar
        dialogButtonClose.setOnClickListener {
            dialog.dismiss()
        }

        dialogButtonAdd.setOnClickListener {
            (recyclerView.adapter as CategoryAdapter).addItem(
                CategoryVO(
                    name = dialogName.text.toString(),
                    description = dialogDescription.text.toString()
                ))
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun initAdapter() {
        recyclerView = binding.categoriesRecyclerView
        val dataList = initListItems() // Obtener la lista de noticias
        val adapter = CategoryAdapter(dataList.toMutableList())
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