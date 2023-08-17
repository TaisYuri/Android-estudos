package com.example.basics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.basics.databinding.ActivityDrawerBinding
import com.google.android.material.navigation.NavigationView

class Drawer : AppCompatActivity() {
    private lateinit var binding: ActivityDrawerBinding
    private lateinit var drawer: DrawerLayout
    private lateinit var navDrawer: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawer = binding.root
        navDrawer = binding.drawerNavigation

        setupDrawer()

        //toolbar
        setSupportActionBar(binding.toolbar4)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //Seta os items do drawer e seus devidos cliques.
    private fun setupDrawer(){
        navDrawer.setNavigationItemSelectedListener { menuItem ->
            drawer.closeDrawers()
            when(menuItem.itemId){
                R.id.drawer_activity1 -> {
                    onBackPressedDispatcher.onBackPressed()
                    true
                }
                R.id.drawer_recycler -> {
                    val intent = Intent(this, RecycleView::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    // Clique no icone da toolbar (que colocamos acima com icone de menu). Responsavel por abrir o drawer
    override fun onSupportNavigateUp(): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return true
    }
}