package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FoxAndNames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());

        int[] indeg = new int[26];

        for (int i = 0; i < words.length - 1; i++) {
            String str1 = words[i];
            String str2 = words[i + 1];

            if (str1.length() > str2.length() && str1.startsWith(str2)) {
                System.out.println("Impossible");
                return;
            }

            for (int k = 0; k < Math.min(str1.length(), str2.length()); k++) {
                char u = str1.charAt(k);
                char v = str2.charAt(k);

                if (u != v) {
                    adj.get(u - 'a').add(v - 'a');
                    indeg[v - 'a']++;
                    break;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.append((char) ('a' + node));

            for (int nextNode : adj.get(node)) {
                indeg[nextNode]--;
                if (indeg[nextNode] == 0) q.offer(nextNode);
            }
        }

        for (int i : indeg) {
            System.out.println(i);
        }

        for (int t : indeg) {
            if (t > 0) {
                System.out.println("Impossible");
                return;
            }
        }

        System.out.println(ans);
    }
}
