package HWIquestions.Easy;

import java.util.HashSet;
import java.util.Scanner;

public class StringStability {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        char[] ch = str.toCharArray();

        int max = 0;
        for (int i = 0; i < ch.length - 1; i++) {
            char temp = ch[i];
            ch[i] = ch[i + 1];
            ch[i + 1] = temp;

            HashSet<String> set= new HashSet<>();

            for (int j = 0; j < ch.length - 1; j++) set.add("" + ch[j] + ch[j + 1]);

            char swapBack = ch[i];
            ch[i] = ch[i + 1];
            ch[i + 1] = swapBack;

            max = Math.max(max, set.size());
        }

        System.out.println(max);
    }
}
