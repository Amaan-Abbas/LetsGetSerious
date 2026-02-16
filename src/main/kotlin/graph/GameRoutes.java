package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GameRoutes {
    static final int mod = 1_000_000_000 + 7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] ways = new int[n + 1];
        ways[1] = 1;
        int[] indegrees = new int[n + 1];

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj.get(from).add(to);
            indegrees[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) if (indegrees[i] == 0) q.offer(i);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int nextCity : adj.get(curr)) {
                if (ways[curr] > 0 && ways[curr] + ways[nextCity] > ways[nextCity]) {
                    ways[nextCity] = (ways[curr] + ways[nextCity]) % mod;
                }

                indegrees[nextCity]--;
                if (indegrees[nextCity] == 0) q.offer(nextCity);
            }
        }

        System.out.println(ways[n]);
    }
}
