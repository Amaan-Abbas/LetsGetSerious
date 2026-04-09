package codeForces.range800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SieveOf67 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        boolean cont = true;

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {

            int size = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < size && cont; i++) {

                int num = Integer.parseInt(st.nextToken());

                if (num == 67) {
                    sb.append("YES").append("\n");
                    cont = false;
                }
            }

            if (!cont)
                cont = true;
            else
                sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }
}
