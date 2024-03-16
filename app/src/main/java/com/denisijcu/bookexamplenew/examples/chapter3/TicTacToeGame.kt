package com.denisijcu.bookexamplenew.examples.chapter3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Define the main composable function for the game
@Composable
fun TicTacToeGame() {
    var currentPlayer by remember { mutableStateOf(Player.X) }
    var board by remember { mutableStateOf(List(9) { CellState.Empty }) }

    // Function to handle cell click
    fun onCellClick(index: Int) {
        if (board[index] == CellState.Empty) {
            board = board.toMutableList().apply { set(index, currentPlayer.toCellState()) }
            currentPlayer = currentPlayer.toggle()
        }
    }

    // Function to reset the game
    fun resetGame() {
        board = List(9) { CellState.Empty }
        currentPlayer = Player.X
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the game board
        Box(
            modifier = Modifier
                .padding(16.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray)
        ) {
            Column {
                repeat(3) { row ->
                    Row {
                        repeat(3) { col ->
                            val index = row * 3 + col
                            Cell(board[index]) { onCellClick(index) }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Display current player
        Text("Current player: ${currentPlayer.name}", modifier = Modifier.padding(8.dp))

        // Button to reset the game
        Button(onClick = { resetGame() }) {
            Text("Reset Game")
        }
    }
}

// Define a composable for a single cell in the game board
@Composable
fun Cell(state: CellState, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(Color.White)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = when (state) {
                CellState.X -> "X"
                CellState.O -> "O"
                else -> ""
            },
            modifier = Modifier.padding(4.dp)
        )
    }
}

// Enum representing the players
enum class Player { X, O }

// Enum representing the state of each cell in the game board
enum class CellState { X, O, Empty }

// Extension function to convert Player enum to CellState enum
fun Player.toCellState(): CellState = when (this) {
    Player.X -> CellState.X
    Player.O -> CellState.O
}

// Extension function to toggle between players
fun Player.toggle(): Player = if (this == Player.X) Player.O else Player.X
