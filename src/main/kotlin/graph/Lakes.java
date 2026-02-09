package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lakes {
    static int rowL, colL;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Pair {
        int col, row;

        public Pair(int row, int col) {
            this.col = col;
            this.row = row;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int k = 0; k < n; k++) {
            rowL = sc.nextInt();
            colL = sc.nextInt();

            int[][] lake = new int[rowL][colL];
            for (int i = 0; i < rowL; i++) {
                for (int j = 0; j < colL; j++) {
                    lake[i][j] = sc.nextInt();
                }
            }

            boolean[][] visited = new boolean[rowL][colL];
            int maxVol = 0;
            for (int i = 0; i < rowL; i++) {
                for (int j = 0; j < colL; j++) {
                    if (!visited[i][j] && lake[i][j] != 0) {
                        maxVol = Math.max(maxVol, bfs(i, j, visited, lake));
                    }
                }
            }
            System.out.println(maxVol);
        }
    }

    public static int bfs(int r, int c, boolean[][] visited, int[][] lake) {
        int vol = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r, c));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            vol += lake[row][col];

            for (int i = 0; i < 4; i++) {
                int newR = row + dr[i];
                int newC = col + dc[i];

                if (newR >= 0 && newC >= 0 && newR < rowL && newC < colL && !visited[newR][newC] && lake[newR][newC] != 0) {
                    visited[newR][newC] = true;
                    q.offer(new Pair(newR, newC));
                }
            }
        }

        return vol;
    }
}
