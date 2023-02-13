package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.test.databinding.FragmentBlankBinding
import com.example.test.viewModels.BonusesViewModel


class BlankFragment : Fragment() {
    private val parentViewModel : BonusesViewModel by activityViewModels()
    private lateinit var binding : FragmentBlankBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlankBinding.inflate(inflater)
        return binding.root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            parentViewModel.setMessage(binding.tvText.text.toString())


        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}