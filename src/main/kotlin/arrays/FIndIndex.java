package arrays;

public class FIndIndex {
    public static int findIndex(int i, int j, int[] arr, int input) {
        while (i <= j) {
            int mid = i + (j - i)/2;

            if (arr[mid] == input) return mid;
            else if (arr[mid] < input) i  = mid + 1;
            else j = mid - 1;
        }

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 10, 13, 16};
        System.out.println(findIndex(0, arr.length - 1, arr, 7));
    }
}
