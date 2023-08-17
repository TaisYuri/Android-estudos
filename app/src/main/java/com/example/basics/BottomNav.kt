package com.example.basics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basics.databinding.ActivityBottomNavBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNav : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNav = binding.bottomNav
        setupBottomNavigation()
    }

    private fun setupBottomNavigation(){
        bottomNav.setOnItemSelectedListener { menuitem ->
            when(menuitem.itemId){
                R.id.bottom_activity1 -> {
                    onBackPressedDispatcher.onBackPressed()
                    true
                }
                R.id.bottom_recycler ->{
                    startActivity(Intent(this, RecycleView::class.java))
                    true
                }
                else -> false
            }
        }
    }
}