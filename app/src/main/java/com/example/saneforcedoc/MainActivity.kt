package com.example.saneforcedoc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.saneforcedoc.databinding.ActivityMainBinding
import com.example.saneforcedoc.repo.MyViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding :ActivityMainBinding

    lateinit var viewModel: MyViewModel
    private var currentFragmentId: Int? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.loadData(this)

        val docfrg = DoctorFragment()
        val checfrg = ChemistFragment()


        binding.bottomNavigation.setOnItemSelectedListener { item ->
            if (currentFragmentId != item.itemId){
                currentFragmentId = item.itemId
                when (item.itemId) {
                    R.id.nav_home -> replaceFragment(docfrg)
                    R.id.nav_profile -> replaceFragment(checfrg)
                }
                true
            }else
                false
        }

        supportFragmentManager.beginTransaction()
            .replace(binding.fragment.id, docfrg)
            .commit()



    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragment.id, fragment)
            .commit()
    }
}