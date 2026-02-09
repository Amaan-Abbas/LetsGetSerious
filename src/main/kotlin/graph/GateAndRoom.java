package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GateAndRoom {
    static int rowL, colL;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int INF = Integer.MAX_VALUE;
    static int maxDis = 0;

    static class Pair {
        int row, col, dis;

        public Pair(int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m  = scanner.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
                if (grid[i][j] == 1) grid[i][j] = INF;
            }
        }

        int[][] minDis = minimumDistance(grid);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(minDis[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] minimumDistance(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;
        boolean[][] visited = new boolean[rowL][colL];

        int rooms = 0;
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < rowL; i++) {
            for (int j = 0; j < colL; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
                else if (grid[i][j] == INF) rooms++;
            }
        }

        if (rooms == 0) return grid;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int dis = curr.dis;

            maxDis = Math.max(maxDis, dis);
            for (int i = 0; i < 4; i++) {
                int newR = row + dr[i];
                int newC = col + dc[i];

                if (newR >= 0 && newC >= 0 && newR < rowL && newC < colL && !visited[newR][newC] && grid[newR][newC] == INF) {
                    visited[newR][newC] = true;
                    grid[newR][newC] = curr.dis + 1;
                    rooms--;
                    q.offer(new Pair(newR, newC, dis + 1));
                }
            }
        }

        return grid;
    }
}
