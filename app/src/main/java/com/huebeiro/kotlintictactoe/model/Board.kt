package com.huebeiro.kotlintictactoe.model

/**
 * Author: Adilson Ribeiro
 * Date: 28/11/17
 */
class Board {
    var winner: Player? = null

    private var cells = getClearCells()
    private var state: GameState? = null
    private var currentTurn: Player? = null

    private enum class GameState {
        IN_PROGRESS, FINISHED
    }

    init {
        restart()
    }

    private fun getClearCells() = Array<Array<Cell>>(3) {
        return Array<Array<Cell>>(3) {
            Array<Cell>(3){
                Cell()
            }
        }
    }
    private fun clearCells(){
        cells = getClearCells()
    }

    fun restart(){
        clearCells()
        winner = null
        currentTurn = Player.X
        state = GameState.IN_PROGRESS
    }

    /**
     * Mark the current row for the player who's current turn it is.
     * Will perform no-op if the arguments are out of range or if that position is already played.
     * Will also perform a no-op if the game is already over.
     *
     * @param row 0..2
     * @param col 0..2
     * @return the player that moved or null if we did not move anything.
     */
    fun mark(row: Int, col: Int): Player? {

        var playerThatMoved: Player? = null

        if (isValid(row, col)) {

            cells[row][col].value = currentTurn
            playerThatMoved = currentTurn

            if (isWinningMoveByPlayer(currentTurn, row, col)) {
                state = GameState.FINISHED
                winner = currentTurn

            } else {
                // flip the current turn and continue
                flipCurrentTurn()
            }
        }

        return playerThatMoved
    }

    fun valueAtCell(row: Int, col: Int): Player? {
        return cells[row][col].value
    }

    private fun isValid(row: Int, col: Int): Boolean {
        return if (state == GameState.FINISHED) {
            false
        } else if (isOutOfBounds(row) || isOutOfBounds(col)) {
            false
        } else !isCellValueAlreadySet(row, col)
    }

    private fun isOutOfBounds(idx: Int): Boolean {
        return idx < 0 || idx > 2
    }

    private fun isCellValueAlreadySet(row: Int, col: Int): Boolean {
        return cells[row][col].value != null
    }

    /**
     * Algorithm adapted from http://www.ntu.edu.sg/home/ehchua/programming/java/JavaGame_TicTacToe.html
     * @param player
     * @param currentRow
     * @param currentCol
     * @return true if `player` who just played the move at the `currentRow`, `currentCol`
     * has a tic tac toe.
     */
    private fun isWinningMoveByPlayer(player: Player?, currentRow: Int, currentCol: Int): Boolean {

        return ((cells[currentRow][0].value === player         // 3-in-the-row

                && cells[currentRow][1].value === player
                && cells[currentRow][2].value === player)
                || (cells[0][currentCol].value === player      // 3-in-the-column

                && cells[1][currentCol].value === player
                && cells[2][currentCol].value === player)
                || (currentRow == currentCol            // 3-in-the-diagonal

                && cells[0][0].value === player
                && cells[1][1].value === player
                && cells[2][2].value === player)
                || (currentRow + currentCol == 2    // 3-in-the-opposite-diagonal

                && cells[0][2].value === player
                && cells[1][1].value === player
                && cells[2][0].value === player))
    }

    private fun flipCurrentTurn() {
        currentTurn = if (currentTurn === Player.X) Player.O else Player.X
    }
}

enum class Player {
    X, O
}

class Cell {
    var value: Player? = null
}