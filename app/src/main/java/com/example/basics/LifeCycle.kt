package com.example.basics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.EditText
import com.example.basics.databinding.ActivityLifeCycleBinding

class LifeCycle : AppCompatActivity() {

    lateinit var binding: ActivityLifeCycleBinding
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifeCycleBinding.inflate(layoutInflater)

        setContentView(binding.root)

        editText = binding.editTextTextPersonName

        //busca informação no bundle para saber se possui informações salvas.
        //o operador let executa quando não é NULLO.
        savedInstanceState?.getString("editTextValue")?.let {
            editText.setText(it)
        }
    }

    //Salva a informação. Desta forma, mesmo com OnDestroy, quando abrir novamente, vamos buscar pelo bundle no OnCreate
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("editTextValue", editText.text.toString() )
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycler", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycler", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycler", "onDestroy")

    }
}