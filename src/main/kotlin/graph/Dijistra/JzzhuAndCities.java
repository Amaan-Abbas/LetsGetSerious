package graph.Dijistra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JzzhuAndCities {
    static class Pair {
        int city;
        long roadLen;

        public Pair(int city, long roadLen) {
            this.city = city;
            this.roadLen = roadLen;
        }
    }

    static class State {
        int to_city;
        long cost;
        int flag;

        public State(int to_city, long cost, int flag) {
            this.to_city = to_city;
            this.cost = cost;
            this.flag = flag;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w =  Long.parseLong(st.nextToken());

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        long[] dis = new long[n + 1];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[1] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        pq.offer(new State(1, 0, 0));
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int newCity = Integer.parseInt(st.nextToken());
            long newCityCost = Long.parseLong(st.nextToken());
            pq.offer(new State(newCity, newCityCost, 1));
        }

        int remove = 0;
        boolean[] visited = new boolean[n + 1];
        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int u = curr.to_city;
            long weight = curr.cost;
            int via = curr.flag;

            if (dis[u] <= weight &&  via == 1) {
                remove++;
                continue;
            } else if (dis[u] > weight && via == 1) {
                dis[u] = weight;
                continue;
            }

            if (visited[u]) continue;
            visited[u] = true;

            for (Pair next : adj.get(u)) {
                int v = next.city;
                long c = next.roadLen;

                if (dis[v] > weight + c) {
                    dis[v] = weight + c;
                    pq.offer(new State(v, dis[v], 0));
                }
            }
        }
        System.out.println(remove);
    }
}
