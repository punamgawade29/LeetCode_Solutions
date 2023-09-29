class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int numRows = board.length;
        int numCols = board[0].length;

        // Mark 'O' cells on the border and their connected 'O's as non-surrounded using DFS
        for (int i = 0; i < numRows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][numCols - 1] == 'O') {
                dfs(board, i, numCols - 1);
            }
        }

        for (int j = 0; j < numCols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[numRows - 1][j] == 'O') {
                dfs(board, numRows - 1, j);
            }
        }

        // Flip the remaining 'O's to 'X's and restore the 'E' cells
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        int numRows = board.length;
        int numCols = board[0].length;

        if (row < 0 || row >= numRows || col < 0 || col >= numCols || board[row][col] != 'O') {
            return;
        }

        // Mark the cell as 'E' (non-surrounded)
        board[row][col] = 'E';

        // Visit adjacent 'O' cells recursively
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
