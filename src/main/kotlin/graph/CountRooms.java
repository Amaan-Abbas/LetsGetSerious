//package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CountRooms {
    static int rowL, colL;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowL = Integer.parseInt(st.nextToken());
        colL = Integer.parseInt(st.nextToken());

        char[][] rooms = new char[rowL][colL];
        int floor = 0;

        for (int i = 0; i < rowL; i++) {
            String line = br.readLine();
            for (int j = 0; j < colL; j++) {
                rooms[i][j] = line.charAt(j);
                if (rooms[i][j] == '.') floor++;
            }
        }


        if (floor == 0) {
            System.out.println(0);
            return;
        }

        boolean[][] visited = new boolean[rowL][colL];
        int room = 0;
        for (int i = 0; i < rowL; i++) {
            for (int j = 0; j < colL; j++) {
                if (!visited[i][j] && rooms[i][j] == '.') {
                    bfs(i, j, visited, rooms);
                    room++;
                }
            }
        }
        System.out.println(room);
    }

    public static void bfs(int r, int c, boolean[][] visited, char[][] rooms) {
        visited[r][c] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nc >= 0 && nr < rowL && nc < colL && !visited[nr][nc] && rooms[nr][nc] != '#') {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
