package com.example.basics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.basics.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

private lateinit var binding: ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recebendo informação de string enviada pela Main
        //obs:  deve-se utilizar a mesma chave setado lá.
        val textoRecebido = intent.getStringExtra("chaveDeAcessoString")
        binding.textInfoRecebida.text = textoRecebido

        //configuração da toolbar
        setSupportActionBar(binding.toolbar2)
        supportActionBar?.title = "Outro Titulo"
        supportActionBar?.setLogo(R.drawable.ic_logo)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Recebendo as informações vindas do bundle
        //Primeiro precisa acessar pela chave do putExtra e depois chamar a chave do bundle
        val bundle = intent.extras?.get("ChaveParaSerializable") as Bundle
        val user = bundle.get("ChaveUser") as User

        binding.textInfoRecebidaDeUser.text = "Nome: ${ user.name }, idade: ${ user.age }"
    }

    //função de GoBack da tollbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    //criação do menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_second_screen, menu)
        return true
    }

    //seta os items e seus devidos cliques (menu)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_save -> {
                Snackbar.make(binding.textSecondLayout, "botão salvar", Snackbar.LENGTH_SHORT)
                    .show()
                return true
            }
            R.id.menu_settings ->  {
                Snackbar.make(binding.textSecondLayout, "botão Settings", Snackbar.LENGTH_SHORT)
                    .show()
                return true
            }
            else -> false
        }
    }
}