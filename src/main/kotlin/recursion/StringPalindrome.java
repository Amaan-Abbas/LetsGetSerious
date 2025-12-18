package recursion;

public class StringPalindrome {
    public static boolean palindromeString(int i, String str) {
        int n = str.length();
        if (i >= n / 2) return true;

        return str.charAt(i) == str.charAt(n - i - 1) && palindromeString(i + 1, str);
    }

    public static void main(String[] args) {
        System.out.println(palindromeString(0, "11211"));
    }
}
