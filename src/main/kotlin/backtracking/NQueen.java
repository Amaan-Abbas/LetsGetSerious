package backtracking;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        nqueens(board, 0);
    }

    public static void nqueens(char[][] board, int row) {
        int n = board.length;

        if (row == n) {
            for (char[] chars : board) {
                for (int j = 0; j < n; j++) {
                    System.out.print(chars[j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'q';
                nqueens(board, row + 1);
                board[row][j] = 'x';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check column
        for (char[] ch : board) {
            if (ch[col] == 'q') return false;
        }

        // check row
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'q') return false;
        }

        // Upper Left diagonal
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'q') return false;
            i--;
            j--;
        }

        // Right Upper corner
        i = row;
        j = col;
        while(i >= 0 && j < n) {
            if (board[i][j] == 'q') return false;
            i--;
            j++;
        }

        return true;
    }
}
