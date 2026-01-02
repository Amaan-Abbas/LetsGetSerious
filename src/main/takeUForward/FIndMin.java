import java.util.ArrayList;

class FIndMin {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        int[] values = {
                379, 392, 405, 418, 430, 445, 457, 470, 482, 495,
                508, 520, 533, 545, 558, 570, 582, 595, 608, 620,
                633, 645, 658, 670, 683, 695, 708, 720, 733, 745,
                758, 770, 783, 795, 808, 820, 833, 845, 858, 870,
                883, 895, 908, 920, 933, 945, 958, 970, 983, 995,
                1008, 1020, 1033, 1045, 1058, 1070, 1083, 1095, 1108, 1120,
                1133, 1145, 1158, 5, 12, 19, 23, 31, 42, 47,
                53, 60, 68, 75, 81, 90, 102, 115, 123, 137,
                145, 152, 160, 172, 185, 193, 205, 217, 225, 238,
                249, 260, 275, 289, 300, 315, 327, 340, 355, 368
        };

        for (int val : values) {
            arr.add(val);
        }

        System.out.println(findMin(arr));

    }

    public static int findMin(ArrayList<Integer> arr) {
        int start = 0, end = arr.size() - 1;
        int min = arr.get(start);

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) >= min) start = mid + 1;
            else {
                min = arr.get(mid);
                end = mid - 1;
            }
        }

        return min;
    }
}