package com.example.basics.NavigationComponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.basics.R
import com.example.basics.databinding.ActivityComponentPaiBinding

class ComponentPai : AppCompatActivity() {
    private lateinit var binding: ActivityComponentPaiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComponentPaiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHost.navController

        binding.buttonNavigation.setOnClickListener {
            navController.navigate(R.id.action_blankFragment1_to_blankFragment2)
        }
    }
}