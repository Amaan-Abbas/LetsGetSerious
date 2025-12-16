package recursion;

public class BacktrackOneToN {
    public static void backtrackOneToN(int n) {
        if (n < 1) return;
        backtrackOneToN(n - 1);
        System.out.println(n);
    }

    public static void reverseBacktrack(int i, int n) {
        if (i > n) return;
        reverseBacktrack(i + 1, n);
        System.out.println(i);
    }

    public static void main(String[] args) {
        backtrackOneToN(10);
        System.out.println();
        reverseBacktrack(1, 10);
    }
}
