package recursion;

public class PrintName {
    public static void printName(String name, int count, int times) {
        if (count > times) return;
        System.out.println(name);
        printName(name, count + 1, times);
    }

    public static void main(String[] args) {
        String name = "Syed Amaan Abbas Naqvi";
        printName(name, 1, 10);
    }
}
