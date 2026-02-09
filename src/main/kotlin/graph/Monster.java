//package graph;

import java.io.*;
import java.util.*;

public class Monster {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[] dir = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] disPlayer = new int[n][m];
        int[][] disMonster = new int[n][m];

        char[][] parent = new char[n][m];
        char[][] labyrinth = new char[n][m];

        boolean[][] visitedM = new boolean[n][m];
        boolean[][] visitedP = new boolean[n][m];

        for (int[] row : disMonster) Arrays.fill(row, Integer.MAX_VALUE);
        for (int[] row : disPlayer) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> qP = new  LinkedList<>();
        Queue<int[]> qM = new  LinkedList<>();

        int pr = 0, pc = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                labyrinth[i][j] =  s.charAt(j);

                if (labyrinth[i][j] == 'M') {
                    qM.offer(new int[]{i, j});
                    disMonster[i][j] = 0;
                    visitedM[i][j] = true;
                }

                if (labyrinth[i][j] == 'A') {
                    pr = i;
                    pc = j;
                    disPlayer[i][j] = 0;
                    visitedP[i][j] = true;
                    qP.offer(new int[]{i, j});
                }
            }
        }

        while (!qM.isEmpty()) {
            int[] curr = qM.poll();
            int row =  curr[0];
            int col =  curr[1];
            int dis = disMonster[row][col];

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visitedM[nr][nc] && labyrinth[nr][nc] == '.' && 1 + dis < disMonster[nr][nc]) {
                    disMonster[nr][nc] = 1 + dis;
                    visitedM[nr][nc] = true;
                    qM.offer(new int[]{nr, nc});
                }
            }
        }

        int er = -1, ec = -1;
        while (!qP.isEmpty()) {
            int[] curr = qP.poll();
            int row = curr[0];
            int col = curr[1];
            int dis = disPlayer[row][col];

            if (row == 0 || col == 0 || row == n - 1 || col == m - 1) {
                er = row;
                ec = col;
                break;
            }

            for (int j = 0; j < 4; j++) {
                int nr = row + dr[j];
                int nc = col + dc[j];
                char direction = dir[j];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visitedP[nr][nc] && labyrinth[nr][nc] == '.' && 1 + dis < disMonster[nr][nc]) {
                    visitedP[nr][nc] = true;
                    disPlayer[nr][nc] = 1 + dis;
                    qP.offer(new int[]{nr, nc});
                    parent[nr][nc] = direction;
                }

            }
        }

        if (er == -1) {
            System.out.println("NO");
            return;
        }

        ArrayList<Character> path = new ArrayList<>();
        int i = er, j = ec;

        while (i != pr || j != pc) {
            path.add(parent[i][j]);
            if (parent[i][j] == 'U') i++;
            else if (parent[i][j] == 'D') i--;
            else if (parent[i][j] == 'L') j++;
            else if (parent[i][j] == 'R') j--;
        }

        Collections.reverse(path);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int pathL = path.size();
        bw.write("YES" + "\n");
        bw.write(pathL + "\n");

        for (int k = 0; k < pathL; k++) {
            bw.write(path.get(k));
        }
        bw.close();
    }
}
