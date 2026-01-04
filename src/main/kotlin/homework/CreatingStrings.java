package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CreatingStrings {
    public static void creatingString(int idx, char[] ch, List<String> ans) {
        int n = ch.length;

        if (idx == n) {
            if (!ans.contains(new String(ch))) ans.add(new String(ch));
            return;
        }

        for (int i = idx; i < n; i++) {
            swap(i, idx, ch);
            creatingString(idx  +1, ch, ans);
            swap(i, idx, ch);
        }
    }

    private static void swap(int i, int j, char[] ch) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();

        char[] arr = str.toCharArray();
        List<String> ans = new ArrayList<>();
        creatingString(0, arr, ans);

        System.out.println(ans.size());
        Collections.sort(ans);
        for(String i : ans) System.out.println(i);
    }
}
