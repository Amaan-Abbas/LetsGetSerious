package tree.segmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class RangeXORQuery {
    static long[] arr;
    static long[] segTree;

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

        buildTree(0, 0, arrSize - 1);

        StringBuilder sb = new  StringBuilder();
        for (int i = 0; i < queries; i++) {

            st = new StringTokenizer(br.readLine());

            int rangeStart = Integer.parseInt(st.nextToken());
            int rangeEnd = Integer.parseInt(st.nextToken());

            long result = queryTree(0, 0, arrSize - 1, rangeStart - 1, rangeEnd - 1);

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

    private static void buildTree(int node, int left, int right) {
        if (left == right) {
            segTree[node] = arr[left];
            return;
        }

        int mid = left + (right - left) / 2;

        buildTree(node * 2 + 1, left, mid);
        buildTree(node * 2 + 2, mid + 1, right);

        segTree[node] = segTree[node * 2 + 1] ^ segTree[node * 2 + 2];
    }

    private static long queryTree(int node, int left, int right, int rangeStart, int rangeEnd) {
        if (left > rangeEnd || right < rangeStart) return 0;

        if (left >= rangeStart && right <= rangeEnd) return segTree[node];

        int mid = left + (right - left) / 2;

        long leftSegment = queryTree(node * 2 + 1, left, mid, rangeStart, rangeEnd);
        long rightSegment = queryTree(node * 2 + 2, mid + 1, right, rangeStart, rangeEnd);

        return leftSegment ^ rightSegment;
    }
}


/*
Segment Tree for Range XOR Query.

Time complexity:
buildTree: O(n)
queryTree: O(log n)
 */
