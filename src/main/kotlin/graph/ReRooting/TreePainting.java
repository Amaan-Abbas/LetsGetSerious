package graph.ReRooting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreePainting {
    static int N;
    static List<Integer>[] edge;
    static long[] subTree;
    static long[] distance;
    static long[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        N = size;

        edge = new ArrayList[size + 1];
        subTree = new long[size + 1];
        distance = new long[size + 1];
        answer = new long[size + 1];

        for (int i = 0; i <= size; i++) {
            edge[i] = new ArrayList<>();
            subTree[i] = 1;
        }


        for (int i = 0; i < size - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edge[a].add(b);
            edge[b].add(a);
        }

        dfs(1, -1);
        answer[1] = distance[1];

        reRooting(1, -1);

        long max = Long.MIN_VALUE;
        for (long element : answer) max = Math.max(max, element);
        max += N;

        System.out.println(max);
    }

    public static void dfs(int node, int parent) {
        for (int child : edge[node]) {
            if (child == parent) continue;
            dfs(child, node);
            subTree[node] += subTree[child];
            distance[node] += distance[child] + subTree[child];
        }
    }

    public static void reRooting(int node, int parent) {
        for (int child : edge[node]) {
            if (child == parent) continue;
            answer[child] = answer[node] + N - 2 * subTree[child];
            reRooting(child, node);
        }
    }
}
