import java.util.Scanner;

public class WeirdAlgo {
    public void weirdAlgo(int n) {
        System.out.print(n);
        if (n == 1) return;
        System.out.print(" ");

        if (n%2 == 0) weirdAlgo(n/2);
        else weirdAlgo(n*3 + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        WeirdAlgo obj = new WeirdAlgo();
        obj.weirdAlgo(n);
    }
}
