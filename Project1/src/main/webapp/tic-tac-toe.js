document.addEventListener('DOMContentLoaded', () => {
    const gameBoard = document.getElementById('game-board');
    const restartButton = document.getElementById('restart-button');
    
    let currentPlayer = 'x';
    let board = Array(9).fill(null);
    let isGameActive = true;

    // Create the game board cells
    for (let i = 0; i < 9; i++) {
        const cell = document.createElement('div');
        cell.className = 'game-cell';
        cell.dataset.index = i;
        gameBoard.appendChild(cell);
    }

    // Event listener for cell clicks
    gameBoard.addEventListener('click', (event) => {
        const cell = event.target;
        const index = cell.dataset.index;
        if (index !== undefined && board[index] === null && isGameActive) {
            board[index] = currentPlayer;
            cell.classList.add(currentPlayer);
            checkWinner();
            currentPlayer = currentPlayer === 'x' ? 'o' : 'x';
        }
    });

    // Check for a winner
    function checkWinner() {
        const winningCombinations = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6]
        ];

        for (const [a, b, c] of winningCombinations) {
            if (board[a] && board[a] === board[b] && board[a] === board[c]) {
                alert(`Player ${board[a].toUpperCase()} wins!`);
                isGameActive = false;
                return;
            }
        }

        if (!board.includes(null)) {
            alert("It's a draw!");
            isGameActive = false;
        }
    }

    // Restart the game
    restartButton.addEventListener('click', () => {
        board = Array(9).fill(null);
        isGameActive = true;
        currentPlayer = 'x';
        document.querySelectorAll('.game-cell').forEach(cell => {
            cell.classList.remove('x', 'o');
        });
    });
});
