package arrays;

public class SumOfN {
    public static void main(String[] args) {
        System.out.println(NumbersSum(5));
    }

    public static int NumbersSum(int n) {
        if (n < 1) return 0;
        return n + NumbersSum(n - 1);
    }
}
