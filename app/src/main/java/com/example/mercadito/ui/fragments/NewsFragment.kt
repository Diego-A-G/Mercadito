package com.example.mercadito.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mercadito.R
import com.example.mercadito.databinding.FragmentHomeBinding
import com.example.mercadito.ui.fragments.adapters.IItemTouched
import com.example.mercadito.ui.fragments.adapters.NewsAdapter
import com.example.mercadito.ui.managers.NewsViewModel
import com.example.mercadito.ui.managers.NewsViewModelFactory
import com.example.mercadito.vo.NewsVO

class NewsFragment : Fragment(), IItemTouched {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var newsViewModel: NewsViewModel

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
        initViewModel()
        setObservers()
    }

    private fun setObservers() {
        newsViewModel.getNews().observe(viewLifecycleOwner){
            initAdapter(it)
        }
        newsViewModel.fetchNews()
    }

    private fun initViewModel() {
        val factory = NewsViewModelFactory(requireContext())
        newsViewModel = ViewModelProvider(this,factory)[NewsViewModel::class.java]
    }

    private fun initAdapter(news: List<NewsVO>) {
        val recyclerView = binding.newsRecyclerView
        val adapter = NewsAdapter(news,this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(newsItem: NewsVO) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_info, null)
        val dialogTitle = dialogView.findViewById<TextView>(R.id.titleDialogTextView)
        val dialogDescription = dialogView.findViewById<TextView>(R.id.descriptionDialogTextView)
        val dialogButtonClose = dialogView.findViewById<Button>(R.id.closeDialogButton)

        // Configura los valores del diálogo con la información de NewsVO
        dialogTitle.text = newsItem.title
        dialogDescription.text = newsItem.description

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

}