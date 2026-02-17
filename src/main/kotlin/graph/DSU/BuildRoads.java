//package graph.DSU;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BuildRoads {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] rank = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        int components = n;

        for (int i = 0; i < m; i++) {
            st = new  StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int p_x = find(x, parent);
            int p_y = find(y, parent);

            if (p_x == p_y) continue;

            if (p_x < p_y) {
                parent[p_x] = p_y;
            } else if (p_x > p_y) {
                parent[p_y] = p_x;
            } else {
                parent[p_x] = p_y;
                rank[p_y]++;
            }
            components--;
        }

        System.out.println(components - 1);

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(find(i, parent));
        }
        ArrayList<Integer> list = new ArrayList<>(set);


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < components - 1; i++) {
            bw.write(list.get(i) + " " + list.get(i + 1));
            bw.newLine();
        }
        bw.flush();
    }

    public static int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }
}
