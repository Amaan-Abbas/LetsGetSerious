package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IceSkating {
    static int[] parent;
    static int[] size;
    static int component;
    public static int addSlopes(int[][] stones) {
        int n = stones.length;
        component = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        size = new int[n];
        Arrays.fill(size, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) union(i, j);
            }
        }

        return component - 1;
    }

    public static void union(int i, int j) {
        int px = find(i);
        int py = find(j);

        if(px == py) return;

        if (size[px] < size[py]) {
            int temp = px;
            px = py;
            py = temp;
        }

        parent[py] = px;
        size[px] += size[py];
        component--;
    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n =  Integer.parseInt(reader.readLine());

        int[][] slopes = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            slopes[i][0] = Integer.parseInt(st.nextToken());
            slopes[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(addSlopes(slopes));
    }
}
