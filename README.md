# Minesweeper (Java Swing)

A classic **Minesweeper** desktop game implementation developed in Java using the Swing framework. This project demonstrates Object-Oriented Programming principles, event handling, and recursive algorithms.

## ℹ️ About
This project replicates the logic and interface of the traditional Minesweeper game. The application features an $8 \times 8$ grid where the player must uncover all non-mine cells without detonating any of the 8 hidden mines. It utilizes Java Swing for the GUI and implements recursive logic (flood fill) to clear empty areas automatically.

## ✨ Features
* **Dynamic Grid:** An $8 \times 8$ board with random mine placement.
* **Interactive UI:** `JButton` grid with mouse hover effects for better user feedback.
* **Game Logic:**
    * **Mine Detection:** Calculates and displays the count of adjacent mines.
    * **Recursive Reveal:** Automatically clears connected empty cells when a safe spot is clicked.
    * **Win/Loss States:** Detects game-over conditions (hitting a mine) and victory conditions (clearing all safe cells).
* **Reset Functionality:** A "Refresh" button to instantly reset the board and start a new game.

## 🛠 Prerequisites
To run this application, you need:
* **Java Development Kit (JDK):** Version 8 or higher.
* **IDE (Optional):** Apache NetBeans, IntelliJ IDEA, or Eclipse (The code includes NetBeans template comments).

## 🚀 How to Run

### Option 1: Using an IDE (NetBeans/IntelliJ/Eclipse)
1.  Open your IDE.
2.  Create a new Java Project.
3.  Create a package named `com.mycompany.minesweeper`.
4.  Copy the `Minesweeper.java` file into this package.
5.  Run the file.

### Option 2: Using Command Line
1.  Navigate to the folder containing the file.
2.  Compile the Java file:
    ```bash
    javac -d . Minesweeper.java
    ```
3.  Run the compiled class:
    ```bash
    java com.mycompany.minesweeper.Minesweeper
    ```
    *(Note: Ensure you are in the root directory where the `com` folder was generated).*

## 🎮 How to Play
1.  **Launch the game:** The board will appear with all cells hidden.
2.  **Left Click:** Click on a square to reveal it.
    * If it's a **Mine (💣)**: The game ends, and you lose.
    * If it's a **Number**: It shows how many mines are adjacent to that square.
    * If it's **Blank**: The game will automatically reveal adjacent blank areas.
3.  **Goal:** Uncover all squares that do not contain mines.
4.  **Refresh:** Click the "Refresh" button at the bottom to restart at any time.

## 📂 Project Structure
* **`Minesweeper.java`**: The main class containing:
    * `initializeBoard()`: Handles random mine placement.
    * `createGUI()`: Sets up the JFrame, GridLayout, and Buttons.
    * `revealCell()`: Recursive method (Flood Fill) to uncover cells.
    * `checkWin()`: Validates if the victory condition is met.


## 👤 Author
**Omkar Dabde**
* **GitHub:** [[Your GitHub Profile Link]](https://github.com/Omkar-204)
* **Email:** [Omkar.dabde09@gmail.com]

---
*This project was created for educational purposes.*
