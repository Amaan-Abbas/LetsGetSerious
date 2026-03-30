package graph.ReRooting;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeDistance2 {
    static long[] subTree;
    static long[] distance;
    static int N;
    static long[] answer;
    static List<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        subTree = new long[size + 1];
        distance = new long[size + 1];
        answer = new long[size + 1];

        edges = new ArrayList[size + 1];
        for (int i = 0; i <= size; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < size - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);
        }

        dfs(1, -1);
        answer[1] = distance[1];

        reRooting(1, -1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (long l : answer) {
            bw.write(l + " ");
        }

        bw.flush();
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
            answer[child] = answer[node] + N - 2 * subTree[child];
            reRooting(child, node);
        }
    }
}
