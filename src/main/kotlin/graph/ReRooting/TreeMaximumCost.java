package graph.ReRooting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeMaximumCost {
    static long[] subTree;
    static long[] distance;
    static long N;
    static long[] answer;
    static List<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        subTree = new long[size + 1];
        distance = new long[size + 1];
        N = 0;
        answer = new long[size + 1];
        edges = new ArrayList[size + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++) {
            subTree[i] = Long.parseLong(st.nextToken());
            N += subTree[i];
        }

        for (int i = 0; i <= size; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < size - 1; i++) {
            st = new  StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);
        }

        dfs(1, -1);
        answer[1] = distance[1];

        reRooting(1, -1);

        long ans = Long.MIN_VALUE;
        for (int i = 1; i <= size; i++) ans = Math.max(ans, answer[i]);

        System.out.println(ans);

    }

    public static void dfs(int node, int parent) {
        for (int child : edges[node]) {
            if (child == parent) continue;
            dfs(child, node);
            subTree[node] += subTree[child];
            distance[node] += distance[child] + subTree[child];
        }
    }

    public static void reRooting(int node, int parent) {
        for (int child : edges[node]) {
            if (child == parent) continue;
            answer[child] = answer[node] + (N - 2 * subTree[child]);
            reRooting(child, node);
        }
    }
}
