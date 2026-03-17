package tree.segmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class DSMQ {
    static long[] segTree;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int size = 4 * n;
        segTree = new long[size];

        buildSegTree(0, 0, n - 1);

        for (int i = 1; i <= q; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int rangeOrAt = Integer.parseInt(st.nextToken());
            long rangeOrValue = Long.parseLong(st.nextToken());

            if (type == 1) updateTree(0, rangeOrAt - 1, rangeOrValue, 0, n - 1);
            else {
                long min = queryMin(0, 0, n - 1, rangeOrAt - 1, (int)rangeOrValue - 1);
                bw.write(min + "\n");
            }
        }
        bw.flush();
    }

    private static void buildSegTree(int idx, int left, int right) {
        if (left == right) {
            segTree[idx] = arr[left];
            return;
        }

        int mid = left + (right - left) / 2;
        buildSegTree(2 * idx + 1, left, mid);
        buildSegTree(2 * idx + 2, mid + 1, right);
        segTree[idx] = Math.min(segTree[2 * idx + 1], segTree[2 * idx + 2]);
    }

    private static long queryMin(int idx, int left, int right, int a, int b) {
        if (right < a || left > b) return Long.MAX_VALUE;
        if (left >= a && right <= b) return segTree[idx];

        int mid = left + (right - left) / 2;
        long leftRange = queryMin(2 * idx + 1, left, mid, a, b);
        long rightRange = queryMin(2 * idx + 2, mid + 1, right, a, b);
        return Math.min(leftRange, rightRange);
    }

    private static void updateTree(int idx, int at, long val, int left, int right) {
        if (left == right) {
            segTree[idx] = val;
            return;
        }

        int mid = left + (right - left) / 2;
        if (at <= mid) updateTree(2 * idx + 1, at, val, left, mid);
        else updateTree(2 * idx + 2, at, val, mid + 1, right);

        segTree[idx] = Math.min(segTree[2 * idx + 1], segTree[2 * idx + 2]);
    }
}
