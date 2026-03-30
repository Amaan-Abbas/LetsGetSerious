package tree.segmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListRemovals {
    static long[] segTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        long[] nodes = new long[n];

        int segSize = 4 * n;
        segTree = new long[segSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            nodes[i] = Long.parseLong(st.nextToken());

        buildTree(0, 0, n - 1);

        for (int i = 0; i < n; i++) {
            long targetNode = nodes[i];
            int ans = queryTree(0, 0, n - 1, targetNode);

            sb.append(arr[ans]).append(" ");
        }

        System.out.println(sb);
    }

    private static int queryTree(int node, int left, int right, long targetNode) {
        if (left == right) {
            segTree[node] = 0;
            return left;
        }

        int mid = left + (right - left) / 2;

        int leftChild = node * 2 + 1;
        int rightChild = node * 2 + 2;

        int ans;

        if (segTree[leftChild] >= targetNode)
            ans = queryTree(leftChild, left, mid, targetNode);
        else
            ans = queryTree(rightChild, mid + 1, right, targetNode - segTree[leftChild]);

        segTree[node] = segTree[leftChild] + segTree[rightChild];

        return ans;

    }

    private static void buildTree(int node, int left, int right) {
        if (left == right) {
            segTree[node] = 1;
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
