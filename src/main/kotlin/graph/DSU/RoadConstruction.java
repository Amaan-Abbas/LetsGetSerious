package graph.DSU;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RoadConstruction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int components = n;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        int[] size = new int[n + 1];

        for (int i = 0; i <= n; i++) parent[i] = i;
        Arrays.fill(rank, 0);
        Arrays.fill(size, 1);
        int maxSize = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int pa = find(a, parent);
            int pb = find(b, parent);

            if (pa == pb) {
                bw.write(components + " " + maxSize + "\n");
                continue;
            }

            if (rank[pa] >  rank[pb]) {
                parent[pb] = pa;
                size[pa] +=  size[pb];
                maxSize = Math.max(maxSize, size[pa]);
            }
            else if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
                size[pb] +=  size[pa];
                maxSize = Math.max(maxSize, size[pb]);
            }
            else {
                parent[pa] = pb;
                size[pb] +=  size[pa];
                rank[pb]++;
                maxSize = Math.max(maxSize, size[pb]);
            }
            components--;

            bw.write(components + " " + maxSize + "\n");
        }
        bw.flush();
    }

    public static int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }
}
