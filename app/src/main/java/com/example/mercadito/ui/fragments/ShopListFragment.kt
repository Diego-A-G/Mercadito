package com.example.mercadito.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mercadito.R
import com.example.mercadito.databinding.FragmentShoplistBinding
import com.example.mercadito.ui.fragments.adapters.ArticleAdapter
import com.example.mercadito.ui.fragments.adapters.IClearAdapter
import com.example.mercadito.ui.managers.ShopListViewModel
import com.example.mercadito.ui.managers.ShopListViewModelFactory
import com.example.mercadito.vo.ItemVO

class ShopListFragment:Fragment(), IClearAdapter {

    private var _binding: FragmentShoplistBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var shopListViewModel: ShopListViewModel

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
        initViewModel()
        initAdapter()
        initButtons()
    }

    private fun initViewModel() {
        val factory = ShopListViewModelFactory(requireContext())
        shopListViewModel = ViewModelProvider(this,factory)[ShopListViewModel::class.java]
    }

    private fun initButtons() {
        binding.addItemFab.setOnClickListener {
            showDialogAddCategory()
        }
        binding.buttonSave.setOnClickListener {
            if ((recyclerView.adapter as ArticleAdapter).itemCount > 0) {
                showConfirmSave()
                cleanAdapter()
            } else showEmptyList()
        }
    }

    private fun cleanAdapter() {
        (recyclerView.adapter as ArticleAdapter).removeAll()
    }

    private fun showConfirmSave() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_info, null)
        val dialogTitle = dialogView.findViewById<TextView>(R.id.titleDialogTextView)
        val dialogDescription = dialogView.findViewById<TextView>(R.id.descriptionDialogTextView)
        val dialogButtonClose = dialogView.findViewById<Button>(R.id.closeDialogButton)

        // Configura los valores del diálogo con la información de NewsVO
        dialogTitle.text = "Guardado"
        val items = (recyclerView.adapter as ArticleAdapter).itemCount
        dialogDescription.text = "Se guardaron $items"

        // Crea y muestra el diálogo
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()

        // Configura el botón de cerrar
        dialogButtonClose.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun initAdapter() {
        recyclerView = binding.itemsRecyclerView
        val dataList = initListItems() // Obtener la lista de noticias
        val adapter = ArticleAdapter(dataList.toMutableList(),this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun showDialogAddCategory() {
        val dialogView = layoutInflater.inflate(R.layout.add_article, null)
        val editTextName = dialogView.findViewById<EditText>(R.id.editTextName)
        val editTextPrice = dialogView.findViewById<EditText>(R.id.editTextPrice)
        val editTextDescription = dialogView.findViewById<EditText>(R.id.editTextDescription)
        val editTextQuantity = dialogView.findViewById<EditText>(R.id.editTextQuantity)
        val buttonAccept = dialogView.findViewById<Button>(R.id.buttonAccept)
        val buttonCancel = dialogView.findViewById<Button>(R.id.buttonCancel)

        // Crea y muestra el diálogo
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()

        // Configura el botón de cerrar
        buttonCancel.setOnClickListener {
            dialog.dismiss()
        }

        buttonAccept.setOnClickListener {
            (recyclerView.adapter as ArticleAdapter).addItem(
                ItemVO(
                    name = editTextName.text.toString(),
                    cost = editTextPrice.text.toString().toDouble(),
                    description = editTextDescription.text.toString(),
                    amount = editTextQuantity.text.toString().toInt()
                )
            )
            dialog.dismiss()
        }

        dialog.show()
    }


    private fun initListItems():List<ItemVO> {
        return listOf(
            ItemVO(1,"papas",5000.toDouble(),"mayooonesa",1),
            ItemVO(1,"papas",5000.toDouble(),"tomate",1),
            ItemVO(1,"papas",5000.toDouble(),"ajo",1),
            ItemVO(1,"papas",5000.toDouble(),"mayooonesa",1)
        )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCleanAdapter() {
        cleanAdapter()
        showEmptyList()
    }

    private fun showEmptyList() {
        Toast.makeText(requireContext(), "No hay items", Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.BOTTOM, 0, 100)
            show()
        }
    }
}