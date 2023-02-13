package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.test.databinding.ActivityBonusesBinding
import com.example.test.viewModels.BonusesViewModel

class BonusesActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBonusesBinding
    private val viewModel : BonusesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBonusesBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

    }


    fun openFragment1(view : View)
    {
        supportFragmentManager.beginTransaction().replace(binding.fragmentView.id, BlankFragment.newInstance()).commit()
    }
    fun openFragment2(view : View)
    {
        supportFragmentManager.beginTransaction().replace(binding.fragmentView.id, BlankFragment2.newInstance()).commit()
    }
}




