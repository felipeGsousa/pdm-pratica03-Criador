package com.example.criador

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class Cores : AppCompatActivity() {

    private lateinit var seekbarRed: SeekBar
    private lateinit var seekbarGreen: SeekBar
    private lateinit var seekbarBlue: SeekBar
    private lateinit var textViewMensagem: TextView
    private lateinit var tela: View
    private lateinit var manipulaTela: ManipulaTela
    private lateinit var seekBarListener: SeekBarListener

    private lateinit var botaoSalvar: Button
    private lateinit var botaoCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cores)

        this.tela = findViewById(R.id.telaCores)

        this.textViewMensagem = findViewById(R.id.codCores)

        this.seekbarRed = findViewById(R.id.seekbarRed)
        this.seekbarGreen = findViewById(R.id.seekbarGreen)
        this.seekbarBlue = findViewById(R.id.seekbarBlue)

        this.manipulaTela = ManipulaTela(seekbarRed, seekbarGreen, seekbarBlue,tela ,textViewMensagem)

        this.seekBarListener = SeekBarListener(manipulaTela)

        this.manipulaTela.atualizaTextView()

        this.seekbarRed.setOnSeekBarChangeListener(seekBarListener)
        this.seekbarGreen.setOnSeekBarChangeListener(seekBarListener)
        this.seekbarBlue.setOnSeekBarChangeListener(seekBarListener)

        this.botaoCancelar = findViewById(R.id.cancelar)
        this.botaoSalvar = findViewById(R.id.salvar)

        this.botaoSalvar.setOnClickListener {
            this.salvar()
        }
        this.botaoCancelar.setOnClickListener {
            this.finish()
        }
    }
    private fun salvar(){
        var cor = (tela.getBackground() as ColorDrawable).color
        val intent = Intent().apply {
            putExtra("Cor", cor)
        }
        setResult(RESULT_OK, intent)

        this.finish()
    }
}


