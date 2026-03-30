package HWIquestions.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZeroOnes {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) arr2[i] = Integer.parseInt(st.nextToken());

        int ans = zeroOnes(arr1, arr2) % MOD;

        System.out.println(ans);
    }

    public static int zeroOnes(int[] arr1, int[] arr2) {

        for (int j : arr2) {

            if (arr1[j - 1] == 0) arr1[j - 1] = 1;
            else arr1[j - 1] = 0;
        }

        int ops = 1;

        for (int i = 0; i < arr1.length; i++) {
            int currMax = 1;

            for (int j = i; j < arr2.length; j++) {


            }
        }

        return ops;
    }
}
