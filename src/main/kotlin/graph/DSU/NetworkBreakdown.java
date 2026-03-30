package graph.DSU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NetworkBreakdown {
    static int[] parent;
    static int[] size;
    static int components;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        size = new int[n + 1];

        ArrayList<int[]> connections = new ArrayList<>();
        ArrayList<int[]> breakdown = new ArrayList<>();

        // Read all connections
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            connections.add(new int[]{x, y});
        }

        // Read breakdown edges
        for (int j = 0; j < b; j++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            breakdown.add(new int[]{x, y});
        }

        // Keep track of broken edges so far
        Set<String> brokenSet = new HashSet<>();

        // Process each breakdown one by one
        for (int i = 0; i < b; i++) {
            int[] brokenEdge = breakdown.get(i);
            brokenSet.add(brokenEdge[0] + "-" + brokenEdge[1]);
            brokenSet.add(brokenEdge[1] + "-" + brokenEdge[0]); // undirected

            // Reset DSU
            for (int j = 0; j <= n; j++) {
                parent[j] = j;
                size[j] = 1;
            }
            components = n;

            // Rebuild DSU with remaining edges
            for (int[] edge : connections) {
                if (!brokenSet.contains(edge[0] + "-" + edge[1])) {
                    union(edge[0], edge[1]);
                }
            }

            System.out.print(components + " ");
        }
    }

    public static void union(int p, int q) {
        int pu = find(p);
        int pv = find(q);

        if (pu == pv) return;
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        components--;
    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}