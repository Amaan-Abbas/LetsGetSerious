package graph;

import java.io.*;
import java.util.*;

public class FlightRoute {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        int[] indeg = new int[n + 1];
        int[] countCities = new int[n + 1];
        int[] parent =  new int[n + 1];
        Arrays.fill(parent, -1);
        countCities[1] = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            indeg[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int city = q.poll();
            for (int nextCity : adj.get(city)) {
                if (countCities[city] > 0 &&  1 + countCities[city] > countCities[nextCity]) {
                    countCities[nextCity] =  countCities[city] + 1;
                    parent[nextCity] = city;
                }

                indeg[nextCity]--;
                if (indeg[nextCity] == 0) {
                    q.offer(nextCity);
                }
            }
        }

        if (countCities[n] == 0 || parent[n] == -1) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        for (int curr = n; curr != -1; curr = parent[curr]) path.add(curr);
        Collections.reverse(path);
        int pathL = path.size();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(pathL + "\n");

        for(int val : path) bw.write(val + " ");
        bw.close();
    }
}
