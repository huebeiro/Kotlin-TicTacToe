package com.huebeiro.kotlintictactoe.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.huebeiro.kotlintictactoe.R
import com.huebeiro.kotlintictactoe.databinding.GameBinding
import com.huebeiro.kotlintictactoe.viewmodel.GameViewModel

class GameActivity : AppCompatActivity() {

    val viewModel = GameViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : GameBinding =  DataBindingUtil.setContentView(this, R.layout.game);
        binding.viewModel = viewModel
        viewModel.onCreate()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_tictactoe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.getItemId()) {
                R.id.action_reset -> {
                    viewModel.onResetSelected()
                    return true
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
