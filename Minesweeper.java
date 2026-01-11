/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.minesweeper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Minesweeper extends JFrame {
    private static final int SIZE = 8;          
    private static final int MINES = 8;       
    private final JButton[][] buttons;                
    private final boolean[][] revealed;               
    private final boolean[][] mines;                  
    private boolean gameOver;
    private JButton refreshButton; // Add a refresh button

    public Minesweeper() {
        buttons = new JButton[SIZE][SIZE];
        revealed = new boolean[SIZE][SIZE];
        mines = new boolean[SIZE][SIZE];
        gameOver = false;

        initializeBoard();
        createGUI();
    }

    // Placing mines randomly
    private void initializeBoard() {
        Random rand = new Random();
        int minesPlaced = 0;
        while (minesPlaced < MINES) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            if (!mines[row][col]) {
                mines[row][col] = true;
                minesPlaced++;
            }
        }
    }

    // Creating the main game interface
    private void createGUI() {
        setTitle("Minesweeper");
        setLayout(new BorderLayout()); 

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(SIZE, SIZE));  

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                final int currentRow = row;
                final int currentCol = col;

                JButton button = new JButton();
                buttons[row][col] = button;
                button.setPreferredSize(new Dimension(50, 50));
                
                // Adding hover effect for the button
                button.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        button.setBackground(Color.LIGHT_GRAY);  // Changes color on hover
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        button.setBackground(null);  // Resets color when mouse exits
                    }
                });

                
                button.addActionListener((ActionEvent e) -> {
                    handleButtonClick(currentRow, currentCol);
                });

                boardPanel.add(button);   
            }
        }

        add(boardPanel, BorderLayout.CENTER);   

        // Add the refresh button at the bottom
        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> resetGame());
        add(refreshButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

     
    private void handleButtonClick(int row, int col) {
        if (gameOver || revealed[row][col]) {
            return;  
        }

        revealCell(row, col);
        updateBoard();

        if (gameOver) {
            JOptionPane.showMessageDialog(this, "You hit a mine! Game over.");
        } else if (checkWin()) {
            JOptionPane.showMessageDialog(this, "Congratulations! You've won the game.");
        }
    }

     
    private void revealCell(int row, int col) {
        if (row < 0 || col < 0 || row >= SIZE || col >= SIZE || revealed[row][col]) {
            return;
        }

        revealed[row][col] = true;

        // If the cell contains a mine
        if (mines[row][col]) {
            buttons[row][col].setText("️💣");
            buttons[row][col].setBackground(Color.RED);   
            gameOver = true;
            return;
        }

        // Count adjacent mines and apply color coding
        int adjacentMines = countAdjacentMines(row, col);
        buttons[row][col].setText((adjacentMines > 0) ? String.valueOf(adjacentMines) : " ");
        buttons[row][col].setEnabled(false);

        // Set button color based on adjacent mines
        switch (adjacentMines) {
            case 1 -> buttons[row][col].setForeground(Color.BLUE);
            case 2 -> buttons[row][col].setForeground(Color.BLUE);
            case 3 -> buttons[row][col].setForeground(Color.BLUE);
            case 4 -> buttons[row][col].setForeground(Color.BLUE);
            case 5 -> buttons[row][col].setForeground(Color.BLUE);
            default -> buttons[row][col].setForeground(Color.BLUE);
        }

        
        if (adjacentMines == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i != 0 || j != 0) {
                        revealCell(row + i, col + j);
                    }
                }
            }
        }
    }

    // Count the number of mines around the given cell
    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE && mines[newRow][newCol]) {
                    count++;
                }
            }
        }
        return count;
    }

     
    private void updateBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (revealed[row][col]) {
                    buttons[row][col].setEnabled(false);  
                }
            }
        }
    }

    // Check if the player has won the game
    private boolean checkWin() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (!mines[row][col] && !revealed[row][col]) {
                    return false;  // If any non-mine cells are not revealed, player has not won
                }
            }
        }
        return true;  // All non-mine cells are revealed, player wins
    }

    // Reset the game state when the refresh button is clicked
    private void resetGame() {
        gameOver = false;

        // Clear the state of the board
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                revealed[row][col] = false;
                mines[row][col] = false;
                buttons[row][col].setText("");   
                buttons[row][col].setEnabled(true);   
                buttons[row][col].setBackground(null);   
                buttons[row][col].setForeground(Color.BLACK);  
            }
        }

         
        initializeBoard();
    }

    // Main method to launch the game
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Minesweeper();
        });
    }
}
