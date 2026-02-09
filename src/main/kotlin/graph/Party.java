package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Party {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = Integer.parseInt(br.readLine());
            if (parent[i] != -1) {
                adj.get(parent[i]).add(i); // manager to employee/parent to child.
            }
        }

        for (int i = 1; i <= n; i++) {
            if (parent[i] == -1) {
                dfs(i, adj, 1);
            }
        }

        System.out.println(result);
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int depth) {
        result = Math.max(result, depth);
        for (int child : adj.get(node)) {
            dfs(child, adj, depth + 1);
        }
    }
}
