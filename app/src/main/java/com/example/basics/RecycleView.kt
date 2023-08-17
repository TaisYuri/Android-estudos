package com.example.basics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basics.databinding.ActivityRecycleViewBinding
import com.google.android.material.snackbar.Snackbar

class RecycleView : AppCompatActivity(), ListAdapterListener {

    private lateinit var binding: ActivityRecycleViewBinding
    private val itemList: MutableList<ListCities> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycleViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lista = binding.recyclerView

        createMockData()

        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = ListAdapter(this, itemList)

        //configuração da tollbar
        setSupportActionBar(binding.toolbar3)
        supportActionBar?.title = "ReciclerView"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)
    }

    override fun onItemClicked(content: String) {
        Snackbar.make(binding.root,content, Snackbar.LENGTH_SHORT).show()
    }

    private fun createMockData(){
        itemList.add(ListCities("Porto Alegre", "RS"))
        itemList.add(ListCities("Florianopolis", "SC"))
        itemList.add(ListCities("São Paulo", "SP"))
    }
}