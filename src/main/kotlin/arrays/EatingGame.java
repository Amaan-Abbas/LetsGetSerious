package arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EatingGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] dishes = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                dishes[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, dishes[i]);
            }

            ArrayList<Integer> winners = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (dishes[i] == max) winners.add(i + 1);
            }

            for (int winner : winners) bw.write(winner + " ");
            bw.write("\n");
        }

        bw.flush();
    }
}
