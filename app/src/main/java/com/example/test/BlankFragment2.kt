package com.example.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.test.databinding.FragmentBlank2Binding
import com.example.test.databinding.FragmentBlankBinding
import com.example.test.viewModels.BonusesViewModel


class BlankFragment2 : Fragment() {
    private val parentViewModel : BonusesViewModel by activityViewModels()
    private lateinit var binding : FragmentBlank2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlank2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvText.text = parentViewModel.getMessage().value
    }


    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()

    }
}