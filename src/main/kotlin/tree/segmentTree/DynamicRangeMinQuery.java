package tree.segmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class DynamicRangeMinQuery {
    static long[] segTree;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrSize = Integer.parseInt(st.nextToken());
        int queries = Integer.parseInt(st.nextToken());

        arr = new long[arrSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrSize; i++) arr[i] = Long.parseLong(st.nextToken());

        int size = 4 * arrSize;
        segTree = new long[size];

        buildTree(0, 0, arrSize - 1);

        for (int i = 1; i <= queries; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int rangeOrAt = Integer.parseInt(st.nextToken());
            long rangeOrValue = Long.parseLong(st.nextToken());

            if (type == 1) updateTree(0, 0, arrSize - 1, rangeOrAt - 1, rangeOrValue);
            else {
                long min = queryTree(0, 0, arrSize - 1, rangeOrAt - 1, (int)rangeOrValue - 1);
                bw.write(min + "\n");
            }
        }
        bw.flush();
    }

    private static void buildTree(int index, int left, int right) {
        if (left == right) {
            segTree[index] = arr[left];
            return;
        }

        int mid = left + (right - left) / 2;
        buildTree(2 * index + 1, left, mid);
        buildTree(2 * index + 2, mid + 1, right);
        segTree[index] = Math.min(segTree[2 * index + 1], segTree[2 * index + 2]);
    }

    private static long queryTree(int index, int left, int right, int queryStart, int queryEnd) {
        if (right < queryStart || left > queryEnd) return Long.MAX_VALUE;
        if (left >= queryStart && right <= queryEnd) return segTree[index];

        int mid = left + (right - left) / 2;
        long leftRange = queryTree(2 * index + 1, left, mid, queryStart, queryEnd);
        long rightRange = queryTree(2 * index + 2, mid + 1, right, queryStart, queryEnd);
        return Math.min(leftRange, rightRange);
    }

    private static void updateTree(int index, int left, int right, int atIndex, long value) {
        if (left == right) {
            segTree[index] = value;
            return;
        }

        int mid = left + (right - left) / 2;
        if (atIndex <= mid) updateTree(2 * index + 1, left, mid, atIndex, value);
        else updateTree(2 * index + 2, mid + 1, right, atIndex, value);

        segTree[index] = Math.min(segTree[2 * index + 1], segTree[2 * index + 2]);
    }
}

/*
Segment Tree for Dynamic Range Minimum Query

Operations:
1 index value -> point update
2 l r -> range minimum query

Time Complexity:
Build : O(n)
Query : O(log n)
Update: O(log n)
*/
