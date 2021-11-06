package com.example.criador

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import java.lang.Integer.parseInt
import java.lang.Long.parseLong

class ManipulaTela {
    private lateinit var seekbarRed: SeekBar
    private lateinit var seekbarGreen: SeekBar
    private lateinit var seekbarBlue: SeekBar
    private lateinit var tela: View
    private lateinit var textViewMensagem: TextView

    constructor(
        seekbarRed: SeekBar,
        seekbarGreen: SeekBar,
        seekbarBlue: SeekBar,
        tela: View,
        textViewMensagem: TextView
    ) {
        this.seekbarRed = seekbarRed
        this.seekbarGreen = seekbarGreen
        this.seekbarBlue = seekbarBlue
        this.tela = tela
        this.textViewMensagem = textViewMensagem
    }

    constructor(tela: View, textViewMensagem: TextView) {
        this.tela = tela
        this.textViewMensagem = textViewMensagem
    }


    fun atualizaTextView(){
        this.textViewMensagem.text = "#" + "%x".format((this.tela.getBackground() as ColorDrawable).color).toUpperCase().subSequence(2,8)

        val text = "%x".format((this.tela.getBackground() as ColorDrawable).color).toUpperCase().subSequence(2,8)

        var textColorRed = parseInt(text.subSequence(0,2).toString(), 16) - 255
        var textColorGreen = parseInt(text.subSequence(2,4).toString(), 16) - 255
        var textColorBlue = parseInt(text.subSequence(4,6).toString(), 16) - 255

        if (textColorRed<0){
            textColorRed = textColorRed*-1
        }
        if (textColorGreen<0){
            textColorGreen = textColorGreen*-1
        }
        if (textColorBlue<0){
            textColorBlue = textColorBlue*-1
        }

        this.textViewMensagem.setTextColor(Color.rgb(textColorRed, textColorGreen, textColorBlue))

        /*
        "%x".format(seekbarRed.progress).toUpperCase() +
                "%x".format(seekbarGreen.progress).toUpperCase() +
                "%x".format(seekbarBlue.progress).toUpperCase()
        */
    }

    fun atualizaTela(){
        this.tela.setBackgroundColor(Color.rgb(seekbarRed.progress, seekbarGreen.progress, seekbarBlue.progress))
    }
}