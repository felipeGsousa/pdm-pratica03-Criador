package com.example.criador

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var botaoNovaCor: Button
    private lateinit var manipulaTela: ManipulaTela
    private lateinit var textViewMensagem: TextView
    private lateinit var tela: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tela = findViewById(R.id.corSalva)

        this.textViewMensagem = findViewById(R.id.codCorSalva)

        this.botaoNovaCor = findViewById(R.id.novaCor)

        this.manipulaTela = ManipulaTela(this.tela, this.textViewMensagem)

        this.manipulaTela.atualizaTextView()

        val resultadoCor = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

            if (it.resultCode == RESULT_OK){
                val cor = it.data?.getSerializableExtra("Cor") as Int
                System.out.println(cor)
                this.tela.setBackgroundColor(cor)
                this.manipulaTela.atualizaTextView()
            }

        }

        this.botaoNovaCor.setOnClickListener {
            val intent = Intent(this, Cores::class.java)
            resultadoCor.launch(intent)
        }


    }
}

