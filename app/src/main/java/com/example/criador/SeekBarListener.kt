package com.example.criador

import android.widget.SeekBar

class SeekBarListener (private var manipulaTela: ManipulaTela) : SeekBar.OnSeekBarChangeListener{

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        manipulaTela.atualizaTela()
        manipulaTela.atualizaTextView()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {}

    override fun onStopTrackingTouch(seekBar: SeekBar) {}
}