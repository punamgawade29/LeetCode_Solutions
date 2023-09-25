class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create sets to store digits for each row, column, and sub-box
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        // Iterate through the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                
                // Skip empty cells
                if (current == '.') {
                    continue;
                }
                
                // Check the current value in the row, column, and sub-box
                if (!rows[i].add(current) || !columns[j].add(current) || !boxes[(i / 3) * 3 + j / 3].add(current)) {
                    return false; // Found a duplicate, the board is invalid
                }
            }
        }
        
        return true; // All checks passed, the board is valid
    }
}

