package graph;

// can store data in two ways: 1. Matrix 2. list

import java.util.Scanner;

public class StoreData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // number of nodes
        int m = scanner.nextInt(); // number of edges

        // 1- matrix format
        int[][] matrix = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        for (int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
