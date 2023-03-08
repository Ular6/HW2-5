package com.example.lesson2_5.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lesson2_5.R
import com.example.lesson2_5.data.CalculateModel
import com.example.lesson2_5.data.KeysObject
import com.example.lesson2_5.data.ViewModel
import com.example.lesson2_5.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val viewModel: ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }
    private fun onClick() = with(binding) {
        binding?.btnRequest?.setOnClickListener {
            viewModel.makeRequest(
                firstName = this!!.firstName.text.toString(),
                secondName = secondName.text.toString()
            ).observe(viewLifecycleOwner) {
                it?.let { sendCode(it) }
            }
        }
    }
    private fun sendCode(model: CalculateModel) {
        binding?.firstName?.setText("")
        binding?.secondName?.setText("")
        val bundle = Bundle()
        bundle.putSerializable(KeysObject.KEY_FOR_BUNDLE, model)
        findNavController().navigate(R.id.resultFragment, bundle)
    }
    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}

