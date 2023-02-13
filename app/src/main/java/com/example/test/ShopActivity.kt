package com.example.test


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.test.databinding.ActivityShopBinding
import com.example.test.viewModels.ShopActivityViewModel


class ShopActivity : AppCompatActivity() {
    lateinit var binding: ActivityShopBinding
    private val  viewModel: ShopActivityViewModel by viewModels()
    private val COSTEASY : Int = 10;
    private val RECIEVEEASY : Int = 1;
    private val COSTMEDIUM : Int = 1000;
    private val RECIEVEMEDIUM : Int = 10;
    private val COSTHARD : Int = 25000;
    private val RECIEVEHARD  : Int = 100;
    private val COSTVERYHARD : Int = 110000;
    private val RECIEVEVERYHARD: Int = 1250;
    private val COSTULTRAHARD : Int = 560000;
    private val RECIEVEULTRAHARD : Int = 10125;
    private val COSTMULTYMEGAGIGAHARD : Int = 2000000;
    private val RECIEVEMULTYMEGAGIGAHARD : Int = 45000;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        binding.apply {
            navMenu.menu.removeItem(R.id.shopButton)
            navMenu.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.homeButton -> { backToMain() }
                    R.id.bonusButton -> {}
                }
                drawerShop.closeDrawer(GravityCompat.START)
               true
            }

        }
        setContentView(binding.root)

        if (savedInstanceState != null) {
            binding.viewModel?.setCounter(savedInstanceState.getInt("counter"))
            binding.viewModel?.setBuster(savedInstanceState.getInt("buster"))
        } else {
            binding.viewModel?.setCounter(intent?.extras?.getInt("counter")!!)
            binding.viewModel?.setBuster(intent?.extras?.getInt("buster")!!)
        }

    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("counter", binding.viewModel?.getCounter()?.value!!)
        outState.putInt("buster", binding.viewModel?.getBuster()?.value!!)
    }



    override fun onBackPressed() {
       backToMain()
    }



    fun IncrementBusterEASY(view : View)
    {
        buyItem(COSTEASY, RECIEVEEASY)
    }

    fun IncrementBusterMEDIUM(view : View)
    {
        buyItem(COSTMEDIUM, RECIEVEMEDIUM)
    }

    fun IncrementBusterHARD(view : View)
    {
        buyItem(COSTHARD, RECIEVEHARD)
    }

    fun IncrementBusterVERYHARD(view : View)
    {
        buyItem(COSTVERYHARD, RECIEVEVERYHARD)
    }

    fun IncrementBusterULTRAHARD(view : View)
    {
        buyItem(COSTULTRAHARD, RECIEVEULTRAHARD)
    }

    fun IncrementBusterULTRAULTRAHARD(view : View)
    {
        buyItem(COSTMULTYMEGAGIGAHARD, RECIEVEMULTYMEGAGIGAHARD)
    }

    fun backToMain() : Unit
    {
        setResult(RESULT_OK,
            Intent().apply {
            putExtra("buster", binding.viewModel?.getBuster()?.value)
            putExtra("counter", binding.viewModel?.getCounter()?.value)
        })
        finish()
    }

    fun buyItem(cost : Int, reward : Int)
    {
        if (!binding.viewModel?.buyItem(cost, reward)!!)
            Toast.makeText(applicationContext, "NOT ENOUGH POINTS", Toast.LENGTH_SHORT).show()

    }

}