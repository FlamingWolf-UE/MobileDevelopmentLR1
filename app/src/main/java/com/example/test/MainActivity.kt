package com.example.test


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.test.databinding.ActivityMainBinding
import com.example.test.viewModels.MainActivityViewModel


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    private var backClicksCount = 0;
    private val  viewModel: MainActivityViewModel by viewModels()
    private var shopActivityLauncher : ActivityResultLauncher<Intent>? = null;

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

            binding.lifecycleOwner = this
            binding.viewModel = viewModel
            shopActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK)
            {
                binding.viewModel?.setCounter(it.data?.getIntExtra("counter", binding.viewModel?.getCounter()?.value!!)!!)
                binding.viewModel?.setBuster(it.data?.getIntExtra("buster", binding.viewModel?.getCounter()?.value!!)!!)

            }
        }

        setContentView(binding.root)
        binding.apply {
            navMenu.menu.removeItem(R.id.homeButton)
            navMenu.setNavigationItemSelectedListener {

                when(it.itemId)
                {
                    R.id.shopButton -> {
                       shopActivityLauncher?.launch(Intent(this@MainActivity, ShopActivity::class.java).apply {
                           putExtra("buster" , binding.viewModel?.getBuster()?.value)
                           putExtra("counter", binding.viewModel?.getCounter()?.value)})

                    }
                    R.id.bonusButton -> {
                        startActivity(Intent(this@MainActivity, BonusesActivity::class.java))

                    }
                }

                drawerMain.closeDrawer(GravityCompat.START)
                true
            }


        }
    }


    override fun onBackPressed() {
        if (backClicksCount == 0)
        {
            Toast.makeText(applicationContext, "Нажмите ещё раз для выхода", Toast.LENGTH_SHORT).show()
            backClicksCount++
            return
        }
        this.finishAffinity();
    }

    fun IncrementCount(view : View)
    {
        binding.viewModel?.incrementCount()
    }



}