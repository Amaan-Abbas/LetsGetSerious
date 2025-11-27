package backtracking;

public class MaxKnight {
    static int max = -1; // Global variable

    public static void main(String[] args) {
        int n = 4;

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }
        maxK(board, 0, 0, 0);
    }

    private static void maxK(char[][] board, int row, int col, int num) {
        int n = board.length;

        if (row == n) {
            max = Math.max(max, num);
            if (max == 5) {
                for (char[] chars : board) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(chars[j] + " ");
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }

        if (isSafe(board, row, col)) {
            board[row][col] = 'k';
            if (col != n - 1) maxK(board, row, col + 1, num + 1);
            else maxK(board, row + 1, 0, num + 1);
            board[row][col] = 'x';
        }

        if (col != n - 1) maxK(board, row, col + 1, num);
        else maxK(board, row + 1, 0, num);
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // All 8 knight moves
        int[][] moves = {
                {-2, -1}, {-2, 1},
                {-1, -2}, {-1, 2},
                {1, -2}, {1, 2},
                {2, -1}, {2, 1}
        };

        for (int[] move : moves) {
            int i = row + move[0];
            int j = col + move[1];
            if (i >= 0 && i < n && j >= 0 && j < n && board[i][j] == 'k') return false;
        }
        return true;
    }
}
