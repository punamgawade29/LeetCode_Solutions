class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        // Define neighbors' directions
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };
        
        // Update the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;
                
                // Count live neighbors for the current cell
                for (int[] dir : directions) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];
                    
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                        if (board[newRow][newCol] == 1 || board[newRow][newCol] == -1) {
                            liveNeighbors++;
                        }
                    }
                }
                
                // Apply the rules to update the cell state
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = -1; // Cell dies
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2;  // Cell becomes alive
                }
            }
        }
        
        // Restore the dummy values to the correct state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0; // Cell dies
                } else if (board[i][j] == 2) {
                    board[i][j] = 1; // Cell becomes alive
                }
            }
        }
    }
}
