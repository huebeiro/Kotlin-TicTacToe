package com.huebeiro.kotlintictactoe.viewmodel

import android.databinding.ObservableArrayMap
import android.databinding.ObservableField
import com.huebeiro.kotlintictactoe.model.Board

/**
 * Author: Adilson Ribeiro
 * Date: 28/11/17
 */
class GameViewModel : ViewModel {

    private val model = Board()
    val cells =  ObservableArrayMap<String, String>()
    val winner = ObservableField<String>()

    fun onResetSelected(){
        model.restart()
        winner.set(null)
        cells.clear()
    }

    fun onClickedCellAt(row: Int, col: Int) {
        val playerThatMoved = model.mark(row, col)
        cells.put("" + row + col, playerThatMoved?.toString())
        winner.set(if (model.winner == null) null else model.winner.toString())
    }

    override fun onCreate() {
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }
}