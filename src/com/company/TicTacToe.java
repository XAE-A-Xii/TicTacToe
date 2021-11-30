package com.company;

import javax.swing.*;

public class TicTacToe {
    private static int playerScore = 0;
    private static int computerScore = 0;

    public static String display(char[][] board) {
        String boardd = board[0][0] + " " + board[0][1] + " " + board[0][2] + "\n" + board[1][0] + " " + board[1][1] + " " + board[1][2]
                + "\n" + board[2][0] + " " + board[2][1] + " " + board[2][2];
        return boardd;
    }

    public static void updateBoard(int position, int player, char[][] gameBoard) {

        char character;
        if (player == 1) {
            character = 'X';
        } else {
            character = 'O';
        }

        switch (position) {

            case 1:
                gameBoard[0][0] = character;
                break;
            case 2:
                gameBoard[0][1] = character;
                break;
            case 3:
                gameBoard[0][2] = character;
                break;
            case 4:
                gameBoard[1][0] = character;
                break;
            case 5:
                gameBoard[1][1] = character;
                break;
            case 6:
                gameBoard[1][2] = character;
                break;
            case 7:
                gameBoard[2][0] = character;
                break;
            case 8:
                gameBoard[2][1] = character;
                break;
            case 9:
                gameBoard[2][2] = character;
                break;

            default:
                break;
        }
    }
    public static void updateBoard(int position, char[][] gameBoard) {

        switch (position) {

            case 1:
                gameBoard[0][0] = '1';
                break;
            case 2:
                gameBoard[0][1] = '2';
                break;
            case 3:
                gameBoard[0][2] = '3';
                break;
            case 4:
                gameBoard[1][0] = '4';
                break;
            case 5:
                gameBoard[1][1] = '5';
                break;
            case 6:
                gameBoard[1][2] = '6';
                break;
            case 7:
                gameBoard[2][0] = '7';
                break;
            case 8:
                gameBoard[2][1] = '8';
                break;
            case 9:
                gameBoard[2][2] = '9';
                break;

            default:
                break;
        }
    }


    public static boolean isValidMove(int move, char[][] gameboard) {

        switch (move) {
            case 1:
                if (gameboard[0][0] != 'X' && gameboard[0][0] != 'O') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (gameboard[0][1] != 'X' && gameboard[0][1] != 'O') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (gameboard[0][2] != 'X' && gameboard[0][2] != 'O') {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (gameboard[1][0] != 'X' && gameboard[1][0] != 'O') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (gameboard[1][1] != 'X' && gameboard[1][1] != 'O') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (gameboard[1][2] != 'X' && gameboard[1][2] != 'O') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if (gameboard[2][0] != 'X' && gameboard[2][0] != 'O') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (gameboard[2][1] != 'X' && gameboard[2][1] != 'O') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (gameboard[2][2] != 'X' && gameboard[2][2] != 'O') {
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }
    }

    public static void playerMove(char[][] gameBoard) {
        int move;
        String movee;
        movee = JOptionPane.showInputDialog(null, "Enter the position where you want to play\n" + display(gameBoard));
        move = Integer.parseInt(movee);
        boolean result = isValidMove(move, gameBoard);

        while (!result) {
            JOptionPane.showMessageDialog(null, "Sorry! Invalid Move. Try again");
            movee = JOptionPane.showInputDialog(null, "Enter the position where you want to play\n" + display(gameBoard));
            move = Integer.parseInt(movee);
            result = isValidMove(move, gameBoard);
        }
        updateBoard(move, 1, gameBoard);
        JOptionPane.showMessageDialog(null, "Your move was recorded;\nnow the computer will play\n" + display(gameBoard));
    }

    public static void computerMove(char[][] gameBoard) {
        int move = bestMove(gameBoard);
        updateBoard(move, 2, gameBoard);
        JOptionPane.showMessageDialog(null, "The computer has played\n" + display(gameBoard));
    }

    public static boolean isGameOver(char[][] gameboard) {

        //Horizontal Win
        if (gameboard[0][0] == 'X' && gameboard[0][1] == 'X' && gameboard[0][2] == 'X') {
            JOptionPane.showMessageDialog(null, "Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[0][0] == 'O' && gameboard[0][1] == 'O' && gameboard[0][2] == 'O') {
            JOptionPane.showMessageDialog(null, "Computer Wins");
            computerScore++;
            return true;
        }
        if (gameboard[1][0] == 'X' && gameboard[1][1] == 'X' && gameboard[1][2] == 'X') {
            JOptionPane.showMessageDialog(null, "Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[1][0] == 'O' && gameboard[1][1] == 'O' && gameboard[1][2] == 'O') {
            JOptionPane.showMessageDialog(null, "Computer Wins");
            computerScore++;
            return true;
        }
        if (gameboard[2][0] == 'X' && gameboard[2][1] == 'X' && gameboard[2][2] == 'X') {
            JOptionPane.showMessageDialog(null, "Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[2][0] == 'O' && gameboard[2][1] == 'O' && gameboard[2][2] == 'O') {
            JOptionPane.showMessageDialog(null, "Computer Wins");
            computerScore++;
            return true;
        }

        //Vertical Wins

        if (gameboard[0][0] == 'X' && gameboard[1][0] == 'X' && gameboard[2][0] == 'X') {
            JOptionPane.showMessageDialog(null, "Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[0][0] == 'O' && gameboard[1][0] == 'O' && gameboard[2][0] == 'O') {
            JOptionPane.showMessageDialog(null, "Computer Wins");
            computerScore++;
            return true;
        }

        if (gameboard[0][1] == 'X' && gameboard[1][1] == 'X' && gameboard[2][1] == 'X') {
            JOptionPane.showMessageDialog(null, "Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[0][1] == 'O' && gameboard[1][1] == 'O' && gameboard[2][1] == 'O') {
            JOptionPane.showMessageDialog(null, "Computer Wins");
            computerScore++;
            return true;
        }

        if (gameboard[0][2] == 'X' && gameboard[1][2] == 'X' && gameboard[2][2] == 'X') {
            JOptionPane.showMessageDialog(null, "Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[0][2] == 'O' && gameboard[1][2] == 'O' && gameboard[2][2] == 'O') {
            JOptionPane.showMessageDialog(null, "Computer Wins");
            computerScore++;
            return true;
        }

        //Diagonal Wins
        if (gameboard[0][0] == 'X' && gameboard[1][1] == 'X' && gameboard[2][2] == 'X') {
            JOptionPane.showMessageDialog(null, "Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[0][0] == 'O' && gameboard[1][1] == 'O' && gameboard[2][2] == 'O') {
            JOptionPane.showMessageDialog(null, "Computer Wins");
            computerScore++;
            return true;
        }

        if (gameboard[2][0] == 'X' && gameboard[1][1] == 'X' && gameboard[0][2] == 'X') {
            JOptionPane.showMessageDialog(null, "Player Wins");
            playerScore++;
            return true;
        }
        if (gameboard[2][0] == 'O' && gameboard[1][1] == 'O' && gameboard[0][2] == 'O') {
            JOptionPane.showMessageDialog(null, "Computer Wins");
            computerScore++;
            return true;
        }

        if (gameboard[0][0] != '1' && gameboard[0][1] != '2' && gameboard[0][2] != '3' && gameboard[1][0] != '4' &&
                gameboard[1][1] != '5' && gameboard[1][2] != '6' && gameboard[2][0] != '7' && gameboard[2][1] != '8' && gameboard[2][2] != '9') {
            JOptionPane.showMessageDialog(null,"Its a tie");
            return true;
        }

        return false;
    }

    public static char[][] resetBoard() {
        char[][] ticTacToe = new char[3][3];
        ticTacToe[0][0] = '1';
        ticTacToe[0][1] = '2';
        ticTacToe[0][2] = '3';
        ticTacToe[1][0] = '4';
        ticTacToe[1][1] = '5';
        ticTacToe[1][2] = '6';
        ticTacToe[2][0] = '7';
        ticTacToe[2][1] = '8';
        ticTacToe[2][2] = '9';
        return ticTacToe;
    }

    public static int checkWinner(char[][] gameboard) {
        //Horizontal Win
        if (gameboard[0][0] == 'X' && gameboard[0][1] == 'X' && gameboard[0][2] == 'X') {
            return -1;
        }
        if (gameboard[0][0] == 'O' && gameboard[0][1] == 'O' && gameboard[0][2] == 'O') {
            return 1;
        }
        if (gameboard[1][0] == 'X' && gameboard[1][1] == 'X' && gameboard[1][2] == 'X') {
            return -1;
        }
        if (gameboard[1][0] == 'O' && gameboard[1][1] == 'O' && gameboard[1][2] == 'O') {
            return 1;
        }
        if (gameboard[2][0] == 'X' && gameboard[2][1] == 'X' && gameboard[2][2] == 'X') {
            return -1;
        }
        if (gameboard[2][0] == 'O' && gameboard[2][1] == 'O' && gameboard[2][2] == 'O') {
            return 1;
        }

        //Vertical Wins

        if (gameboard[0][0] == 'X' && gameboard[1][0] == 'X' && gameboard[2][0] == 'X') {
            return -1;
        }
        if (gameboard[0][0] == 'O' && gameboard[1][0] == 'O' && gameboard[2][0] == 'O') {
            return 1;
        }

        if (gameboard[0][1] == 'X' && gameboard[1][1] == 'X' && gameboard[2][1] == 'X') {
            return -1;
        }
        if (gameboard[0][1] == 'O' && gameboard[1][1] == 'O' && gameboard[2][1] == 'O') {
            return 1;
        }

        if (gameboard[0][2] == 'X' && gameboard[1][2] == 'X' && gameboard[2][2] == 'X') {
            return -1;
        }
        if (gameboard[0][2] == 'O' && gameboard[1][2] == 'O' && gameboard[2][2] == 'O') {
            return 1;
        }

        //Diagonal Wins
        if (gameboard[0][0] == 'X' && gameboard[1][1] == 'X' && gameboard[2][2] == 'X') {
            return -1;
        }
        if (gameboard[0][0] == 'O' && gameboard[1][1] == 'O' && gameboard[2][2] == 'O') {
            return 1;
        }

        if (gameboard[2][0] == 'X' && gameboard[1][1] == 'X' && gameboard[0][2] == 'X') {
            return -1;
        }
        if (gameboard[2][0] == 'O' && gameboard[1][1] == 'O' && gameboard[0][2] == 'O') {
            return 1;
        }

        if (gameboard[0][0] != '1' && gameboard[0][1] != '2' && gameboard[0][2] != '3' && gameboard[1][0] != '4' &&
                gameboard[1][1] != '5' && gameboard[1][2] != '6' && gameboard[2][0] != '7' && gameboard[2][1] != '8' && gameboard[2][2] != '9') {
            return 0;
        }
        return 2;
    }


    public static void main(String[] args) {
        // write your code here
        char[][] ticTacToe = new char[3][3];
        ticTacToe[0][0] = '1';
        ticTacToe[0][1] = '2';
        ticTacToe[0][2] = '3';
        ticTacToe[1][0] = '4';
        ticTacToe[1][1] = '5';
        ticTacToe[1][2] = '6';
        ticTacToe[2][0] = '7';
        ticTacToe[2][1] = '8';
        ticTacToe[2][2] = '9';
        boolean gameOver = false;
        boolean playAgain = true;
        JOptionPane.showMessageDialog(null, "Welcome to Tic Tac Toe!!\nYou will have X and the computer will have O");
        while (playAgain) {
            while (!gameOver) {
                playerMove(ticTacToe);
                gameOver = isGameOver(ticTacToe);
                if (gameOver) {
                    break;
                }

                computerMove(ticTacToe);
                gameOver = isGameOver(ticTacToe);
                if (gameOver) {
                    break;
                }
            }
            String result = JOptionPane.showInputDialog(null, "Player Score: " + playerScore + "\n" + "Computer Score: " + computerScore
                    + "\nWould you like to play again? Y/N");

            switch (result) {
                case "Y":
                case "y":
                    playAgain = true;
                    JOptionPane.showMessageDialog(null, "Dope! Let's play again");
                    ticTacToe = resetBoard();
                    gameOver = false;
                    break;

                case "N":
                case "n":
                    playAgain = false;
                    JOptionPane.showMessageDialog(null, "Thanks for playing");
                    break;
                default:
                    break;
            }
        }
    }
    public static int bestMove(char[][] gameboard)
    {
        int move = 0;
        int bestScore = -10;
        int bestMove = 10;
        int[] moves = {1,2,3,4,5,6,7,8,9};
        for(int i = 0 ; i <moves.length ; i++)
        {
            boolean result = isValidMove(moves[i],gameboard);
            if(result)
            {
                move = moves[i];
                int temp = move ;
                char[][] gameboard1 = gameboard.clone();
                updateBoard(move,2,gameboard1);
                int score = minimax(gameboard1,0,false);
                updateBoard(temp,gameboard1);
                if(score > bestScore)
                {
                    bestScore = score;
                    bestMove = move;
                }
            }
        }
        return bestMove;
    }
    public static int minimax(char[][] gameboard,int depth,boolean isMaximising)
    {
        int score;
        if(checkWinner(gameboard) != 2)
        {
            score = checkWinner(gameboard);
            return score;
        }
        if(isMaximising)
        {
            int move = 0;
            int bestScore = -10;
            int[] moves = {1,2,3,4,5,6,7,8,9};
            for(int i = 0 ; i <moves.length ; i++)
            {
                boolean result = isValidMove(moves[i],gameboard);
                if(result)
                {
                    move = moves[i];
                    int temp = move;
                    updateBoard(move,2,gameboard);
                    score = minimax(gameboard,depth+1,false);
                    updateBoard(temp,gameboard);
                    if(score > bestScore)
                    {
                        bestScore = score;
                    }
                }
            }
            return bestScore;
        }
        else
        {
            int move = 0;
            int bestScore = 10;
            int[] moves = {1,2,3,4,5,6,7,8,9};
            for(int i = 0 ; i <moves.length ; i++)
            {
                boolean result = isValidMove(moves[i],gameboard);
                if(result)
                {
                    move = moves[i];
                    int temp = move;
                    updateBoard(move,1,gameboard);
                    score = minimax(gameboard,depth+1,true);
                    updateBoard(temp,gameboard);
                    if(score < bestScore)
                    {
                        bestScore = score;
                    }
                }
            }
            return bestScore;
        }
    }
}

