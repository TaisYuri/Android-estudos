package com.example.basics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basics.databinding.ItemRecyclerBinding

class ListAdapter(val listener:ListAdapterListener, val listCities: MutableList<ListCities>): RecyclerView.Adapter<ListAdapter.ListItemViewHolder>() {

    //Criação da RecyclerView com a ViewHolder (responsavel por criar os items)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)  ------- Quando nao usamos BINDING, retornamos uma VIEW para a ViewHolder
    }

    //passa o conteudo da ViewHolder para o item atual (pega pela posição/mexe card por card)
    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        var item = listCities[position]
        holder.position.text = position.toString()
        holder.conteudo.text = item.name
        holder.state.text = item.state

        //acessando o ITEM raiz
        holder.viewRoot.setOnClickListener{
            listener.onItemClicked(item.name)
        }

    }

    override fun getItemCount(): Int {
        return listCities.size
    }

    //Classe ViewHolder responsavel por criar o item
    class ListItemViewHolder(binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root){
        var position = binding.textViewPosicao
        var conteudo = binding.textViewConteudo
        var state = binding.textViewState

        //repassando o root para o holder
        var viewRoot = binding.root
    }
}

interface ListAdapterListener{
    fun onItemClicked(content: String)
}