package graph.DSU;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Beauty {
    static int[] parent;
    static int[] size;
    static Map<Integer, HashSet<Integer>> componentMap;
    static Map<Integer, Integer> componentBeauty;

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
//        int t = scanner.nextInt();

        // initialization
        parent = new int[n + 1];
        size = new int[n + 1];
        componentMap = new HashMap<>();
        componentBeauty = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            size[i] = 1;
            parent[i] = i;
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            componentMap.put(i, set);
            componentBeauty.put(i, 1);
        }

        long totalBeauty = 0;
        while (q-- > 0) {
            int type = scanner.nextInt();
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            if (type == 1) {
                int pu = find(u);
                int pv = find(v);

                if (pu != pv) {
                    if (size[pu] < size[pv]) {
                        int temp = size[pu];
                        size[pu] = size[pv];
                        size[pv] = temp;
                    }

                    parent[pv] = parent[pu];
                    size[pu] += size[pv];

                    HashSet<Integer> big = componentMap.get(pu);
                    HashSet<Integer> small = componentMap.get(pv);
                    int beautyBig = componentBeauty.get(pu);

                    for (int node : small) {
                        boolean left = big.contains(node - 1);
                        boolean right = big.contains(node + 1);

                        if (left && right) beautyBig--;
                        else if (!left && !right) beautyBig++;

                        big.add(node);
                    }

                    componentMap.put(pu, big);
                    componentBeauty.put(pu, beautyBig);

                    componentMap.remove(pv);
                    componentBeauty.remove(pv);
                }
            } else if (type == 2) {
                int pu = find(u);
                int bu = componentBeauty.get(pu);
                totalBeauty += bu;
            }
        }

        System.out.println(totalBeauty);
    }
}
