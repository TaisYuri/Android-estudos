package com.example.basics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.basics.NavigationComponents.MainActivityComponent
import com.example.basics.databinding.ActivityMainBinding
import java.io.Serializable

//cria  o binding para ser inicializado no momento da execução
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //instancia o binding com o layout da ActivityMain
        binding = ActivityMainBinding.inflate(layoutInflater)
        //seta o contentView com o binding criado
        setContentView(binding.root)

        binding.buttonLayout.setOnClickListener {
            Toast.makeText(this, "Olá! seja bem vindo", Toast.LENGTH_SHORT).show()
            binding.textViewLayout.text = "Teste de mudança de texto ao clicar no botão"
        }

        //Acessando uma segunda activity
        binding.buttonAccessSecondActivity.setOnClickListener {
            //cria a intenção de acessar outra activity
            val intent = Intent(this, SecondActivity::class.java)

            //Passando informaçao primitiva para segunda activity (ex: STRING)
            intent.putExtra("chaveDeAcessoString", "Passando informação para segunda activity")

            //Passando informação de dataClass para segunda activity (ex: Classe USER)
            var user = User("Tais", 30)

            //Cria um pacote(budle) do tipo Serializable para envio a outra activity
            val bundle = Bundle()
            bundle.putSerializable("ChaveUser", user)

            intent.putExtra("ChaveParaSerializable", bundle)

            startActivity(intent)  //starta a nova intenção de acessar
        }

        //Acessando um Fragment
        val fragmenteTransaction = supportFragmentManager.beginTransaction()

        //adiciona o fragment em fragmentLayoutFirst( espaço criado no layout com este nome)
        //fragmenteTransaction.add(R.id.fragmentLayout, FirstFragment())
        //fragmenteTransaction.commit()

        //Troca o fragment1 para fragment2 ao clicar no botão
        binding.buttonTrocarFragment.setOnClickListener {
            val fragmentSecond = SecondFragment.newInstance("Passando informações para o fragment", "Hellow World")

            fragmenteTransaction.replace(R.id.fragmentLayout, fragmentSecond)
            fragmenteTransaction.commit()  //só pode haver um commit. Então o firstfragment está setado direto no layout
        }

        binding.buttonRecycler.setOnClickListener{
            val intent = Intent(this, RecycleView::class.java)
            startActivity(intent)
        }

        binding.buttonDrawer.setOnClickListener{
            val intent = Intent(this, Drawer::class.java)
            startActivity(intent)
        }

        binding.buttonBottom.setOnClickListener {
            startActivity(Intent(this, BottomNav::class.java))
        }

        binding.buttonNavComponent.setOnClickListener {
            startActivity(Intent(this, MainActivityComponent::class.java))
        }
    }


}

data class User(
    val name: String,
    val age: Int
):Serializable  //para ser usado dentro do budle, precisa ser do tipo Serializable