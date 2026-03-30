package tree.lazyPropogation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RangeUpdateQueries {
    static long[] segTree;
    static long[] arr;
    static long[] lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrSize = Integer.parseInt(st.nextToken());
        int queries = Integer.parseInt(st.nextToken());

        arr = new long[arrSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrSize; i++) arr[i] = Long.parseLong(st.nextToken());

        int size = 4 * arrSize;
        segTree = new long[size];
        lazy = new long[size];

        buildTree(0, 0, arrSize - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queries; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int rangeStart = Integer.parseInt(st.nextToken());
                int rangeEnd = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());

                updateTree(0, 0, arrSize - 1, rangeStart - 1, rangeEnd - 1, value);
            } else {
                int position = Integer.parseInt(st.nextToken());

                long atPositon = getTree(0, 0, arrSize - 1, position - 1);

                sb.append(atPositon).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static long getTree(int node, int left, int right, int position) {
        if (lazy[node] != 0) {
            segTree[node] += (right - left + 1) * lazy[node];

            if (left != right) {
                lazy[node * 2 + 1] += lazy[node];
                lazy[node * 2 + 2] += lazy[node];
            }

            lazy[node] = 0;
        }

        if (left == right) return segTree[node];

        int mid = left + (right - left) / 2;

        if (position <= mid)
            return getTree(node * 2 + 1, left, mid, position);
        else
            return getTree(node * 2 + 2, mid + 1, right, position);
    }

    public static void updateTree(int node, int left, int right, int rangeStart, int rangeEnd, long value) {
        if (lazy[node] != 0) {
            segTree[node] += (right - left + 1) * lazy[node];

            if (left != right) {
                lazy[node * 2 + 1] += lazy[node];
                lazy[node * 2 + 2] += lazy[node];
            }

            lazy[node] = 0;
        }

        if (right < rangeStart || left > rangeEnd) return;

        if (rangeStart <= left && rangeEnd >= right) {
            segTree[node] += (right - left + 1) * value;

            if (left != right) {
                lazy[node * 2 + 1] += value;
                lazy[node * 2 + 2] += value;
            }

            return;
        }

        int mid = left + (right - left) / 2;

        int leftChild = node * 2 + 1;
        int rightChild = node * 2 + 2;

        updateTree(leftChild, left, mid, rangeStart, rangeEnd, value);
        updateTree(rightChild, mid + 1, right, rangeStart, rangeEnd, value);

        segTree[node] = segTree[leftChild] + segTree[rightChild];
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
