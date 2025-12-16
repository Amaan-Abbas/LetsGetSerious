package recursion;

public class OneToN {
    public static void oneToN(int i, int n) {
        if (i > n) return;
        System.out.println(i);
        oneToN(i + 1, n);
    }

    public static void reverseOneToN(int i) {
        if (i == 0) return;
        System.out.println(i);
        reverseOneToN(i - 1);
    }

    public static void main(String[] args) {
        oneToN(1, 10);
        System.out.println();
        reverseOneToN(10);
    }
}
