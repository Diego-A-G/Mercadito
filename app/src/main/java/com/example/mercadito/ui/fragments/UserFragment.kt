package com.example.mercadito.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mercadito.databinding.FragmentUserBinding
import com.example.mercadito.ui.managers.UserViewModel
import com.example.mercadito.ui.managers.UserViewModelFactory
import com.example.mercadito.vo.UserVO

class UserFragment:Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!
    private lateinit var userViewModel: UserViewModel
    private var isEdit = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initListeners()
        loadInformation()

    }

    private fun initViewModel() {
        val factory = UserViewModelFactory(requireContext())
        userViewModel = ViewModelProvider(this,factory)[UserViewModel::class.java]
    }

    private fun initListeners() {
        binding.editIcon.setOnClickListener {
            changeVisibility()
        }
        binding.acceptIcon.setOnClickListener {
            showDataSaved()
        }
        binding.cancelIcon.setOnClickListener {
            loadInformation()
            changeVisibility()
        }
    }

    private fun changeVisibility() {
        binding.editTextName.isEnabled = !isEdit
        binding.editTextEmail.isEnabled = !isEdit
        binding.editTextPassword.isEnabled = !isEdit
        binding.editTextAlias.isEnabled = !isEdit
        binding.acceptIcon.isEnabled = !isEdit
        binding.cancelIcon.isEnabled = !isEdit
        isEdit = !isEdit
    }

    private fun showDataSaved() {
        Toast.makeText(requireContext(), "Datos guardados", Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.BOTTOM, 0, 100)
            show()
        }
    }

    private fun loadInformation() {
        val userVO = UserVO(1,"Diego Gonzalez","dagon@gmail","12345","dagon")
        binding.editTextName.text = Editable.Factory.getInstance().newEditable(userVO.name)
        binding.editTextEmail.text = Editable.Factory.getInstance().newEditable(userVO.email)
        binding.editTextPassword.text = Editable.Factory.getInstance().newEditable(userVO.password)
        binding.editTextAlias.text = Editable.Factory.getInstance().newEditable(userVO.alias)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}