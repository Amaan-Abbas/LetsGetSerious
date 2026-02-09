package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Labyrinth {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[] dir = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sr = 0, sc = 0, er = 0, ec = 0;
        char[][] labyrinth = new char[n][m];
        char[][] parent = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                labyrinth[i][j] = input.charAt(j);
                if (labyrinth[i][j] == 'A') {
                    sr = i;
                    sc = j;
                } else if (labyrinth[i][j] == 'B') {
                    er = i;
                    ec = j;
                }
            }
        }

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                char direction = dir[i];

                if (newR >= 0 && newC >= 0 && newR < n && newC < m && !visited[newR][newC] && labyrinth[newR][newC] == 'B') {
                    parent[newR][newC] = direction;
                    visited[newR][newC] = true;
                    break;
                }

                if (newR >= 0 && newC >= 0 && newR < n && newC < m && !visited[newR][newC] && labyrinth[newR][newC] == '.') {
                    visited[newR][newC] = true;
                    q.offer(new int[]{newR, newC});
                    parent[newR][newC] = direction;
                }
            }
        }

        if (!visited[er][ec]) {
            System.out.println("NO");
            return;
        }

        ArrayList<Character> path = new ArrayList<>();
        int i = er, j = ec;

        while (i != sr || j != sc) {
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
        bw.flush();
    }
}