package basics;

import java.util.Scanner;

public class HashingCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input string
        String s = sc.next();

        // pre-compute hash for all characters
        //array corresponds to all the ascii values in the ascii table.
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            //accesses the chars in the string and store the value in the corresponding place in the hash
            hash[s.charAt(i)]++;
        }

        // number of queries
        int q = sc.nextInt();

        while (q-- > 0) {
            char c = sc.next().charAt(0);
            // fetch frequency
            System.out.println(hash[c]);
        }

        sc.close();
    }
}
