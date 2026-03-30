package tree.lazyPropogation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RangeUpdateAndSum {
    static long[] arr, segTree, lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int arrSize = Integer.parseInt(st.nextToken());
        int queries = Integer.parseInt(st.nextToken());

        arr = new long[arrSize];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arrSize; i++) arr[i] = Long.parseLong(st.nextToken());

        int size = 4 * arrSize;

        segTree = new long[size];
        lazy = new long[size];

        buildTree(0, 0, arrSize - 10);

        StringBuilder br = new StringBuilder();
        for (int i = 0; i < queries; i++) {
            st = new StringTokenizer(reader.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int qs = Integer.parseInt(st.nextToken());
                int qr = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());


            }
        }
    }

    public static void buildTree(int node, int left, int right) {
        if (left == right) {
            segTree[node] = arr[left];
            return;
        }

        int mid = left + (right - left) / 2;

        int leftChild = node * 2 + 1;
        int rightChild = node * 2 + 2;

        buildTree(leftChild, left, mid);
        buildTree(rightChild, mid + 1, right);

        segTree[node] = segTree[leftChild] + segTree[rightChild];
    }
}
