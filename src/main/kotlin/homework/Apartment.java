package homework;

import java.util.Arrays;
import java.util.Scanner;

public class Apartment {
    public static int allotApartment(int m, int diff, int[] room, int[] available) {
        Arrays.sort(room);
        Arrays.sort(available);

        int i = 0, j = 0, allotted = 0;

        while (i < room.length && j < m) {
            if (available[j] <= room[i] + diff && available[j] >= room[i] - diff) {
                i++;
                j++;
                allotted++;

            } else if (room[i] < available[j]) i++;
            else j++;
        }

        return allotted;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int diff = sc.nextInt();

        int[] room = new int[n];
        for (int i = 0; i < n; i++) {
            room[i] = sc.nextInt();
        }

        int[] available = new int[m];
        for (int j = 0; j < m; j++) {
            available[j] = sc.nextInt();
        }

        int result = allotApartment(m, diff, room, available);
        System.out.println(result);
    }

}
