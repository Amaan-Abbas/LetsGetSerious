package graph.Dijistra;

import java.io.*;
import java.util.*;

public class CodeForce20C {

    static class Pair {
        int node;
        long dis;

        public Pair(int node, long dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] distance = new long[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dis, b.dis));
        pq.offer(new Pair(1, 0));

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 1; i <= m; i++) {
            st = new  StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.node;
            long d =  p.dis;

            if (d > distance[u]) continue;

            for (Pair next : adj.get(u)) {
                int v = next.node;
                long dis = next.dis;

                if (distance[v] > dis + distance[u]) {
                    parent[v] = u;
                    distance[v] = dis + distance[u];
                    pq.offer(new Pair(v, distance[v]));
                }
            }
        }

        if (distance[n] == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        for (int i = n; i != -1; i = parent[i]) path.add(i);
        Collections.reverse(path);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : path) bw.write(i + " ");
        bw.close();
    }
}
