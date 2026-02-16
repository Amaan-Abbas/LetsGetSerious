package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class MessageRoute {
    static int rowL, colL;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowL = Integer.parseInt(st.nextToken());
        colL = Integer.parseInt(st.nextToken());

        int[][] connections = new int[colL][2];
        for (int i = 0; i < colL; i++) {
            st = new StringTokenizer(br.readLine());
            connections[i][0] = Integer.parseInt(st.nextToken());
            connections[i][1] = Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<Integer>> adj = adjList(connections);
        boolean[] visited = new boolean[rowL + 1];
        bfs(1, rowL, 0, visited , adj);
    }

    public static void bfs(int sc, int se, int count, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[sc] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(sc);

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            if (node == se) {
                count++;
                break;
            }

            for (int nextNode : adj.get(node)) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.offer(nextNode);

                }
            }
        }

        if (!visited[se]) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        System.out.println(count);
    }

    public static ArrayList<ArrayList<Integer>> adjList(int[][] connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= rowL; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < colL; i++) {
            int u =  connections[i][0];
            int v =  connections[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }
}
