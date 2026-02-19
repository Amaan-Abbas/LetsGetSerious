package graph.DSU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RoadReparation {
    static class edges {
        int u, v;
        long cost;
        public edges(int u, int v, long cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;

        int[] rank = new int[n + 1];
        Arrays.fill(rank, 0);

        int component = n;
        long value = 0;

        PriorityQueue<edges> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            pq.offer(new edges(u, v, cost));
        }

        while (!pq.isEmpty()) {
            edges curr = pq.poll();
            int u = curr.u;
            int v = curr.v;
            long cost = curr.cost;

            int pu = find(u, parent);
            int pv =  find(v, parent);

            if (pu == pv) continue;

            if (rank[pu] <  rank[pv]) parent[pu] = pv;
            else if (rank[pu] > rank[pv]) parent[pv] = pu;
            else {
                parent[pu] = pv;
                rank[pv]++;
            }
            component--;
            value += cost;
        }

        if (component == 1) System.out.println(value);
        else System.out.println("IMPOSSIBLE");
    }

    public static int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }
}