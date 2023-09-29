class Solution {
    public int totalNQueens(int n) {
        int[] queens = new int[n];
        return solveNQueens(queens, 0, n);
    }

    private int solveNQueens(int[] queens, int row, int n) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col, n)) {
                queens[row] = col;
                count += solveNQueens(queens, row + 1, n);
            }
        }

        return count;
    }

    private boolean isValid(int[] queens, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - i == col - row || queens[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }
}
