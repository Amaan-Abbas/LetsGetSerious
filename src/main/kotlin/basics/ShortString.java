package basics;

import java.util.Scanner;

public class ShortString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            if (str[i].length() > 10) {
                str[i] = "" + str[i].charAt(0) + str[i].substring(0, str[i].length() - 2).length() + str[i].charAt(str[i].length() - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(str[i]);
        }
    }
}
