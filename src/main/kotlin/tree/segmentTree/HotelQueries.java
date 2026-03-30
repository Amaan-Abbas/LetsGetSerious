package tree.segmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HotelQueries {
    static long[] segTree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrSize = Integer.parseInt(st.nextToken());
        int queries = Integer.parseInt(st.nextToken());

        arr = new long[arrSize];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arrSize; i++) arr[i] = Long.parseLong(st.nextToken());

        int segSize = 4 * arrSize;
        segTree = new long[segSize];

        buildTree(0, 0, arrSize - 1);

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < queries; i++) {
            long roomReq = Long.parseLong(st.nextToken());

            long ans = allocateRoom(0, 0, arrSize - 1, roomReq);

            sb.append(ans == -1 ? 0 : ans + 1).append(" ");
        }

        System.out.println(sb);
    }

    public static void buildTree(int node, int rangeStart, int rangeEnd) {
        if (rangeStart == rangeEnd) {
            segTree[node] = arr[rangeStart];
            return;
        }

        int mid = rangeStart + (rangeEnd - rangeStart) / 2;

        buildTree(node * 2 + 1, rangeStart, mid);
        buildTree(node * 2 + 2, mid + 1, rangeEnd);

        segTree[node] = Math.max(segTree[node * 2 + 1], segTree[node * 2 + 2]);
    }

    public static long allocateRoom(int node, int rangeStart, int rangeEnd, long roomReq) {

        if (segTree[node] < roomReq) return -1;

        if (rangeStart == rangeEnd) {
//            arr[rangeStart] -= roomReq;
            segTree[node] -= roomReq;
            return rangeStart;
        }

        int mid = rangeStart + (rangeEnd - rangeStart) / 2;

        long ans;

        if (segTree[node * 2 + 1] >= roomReq)
            ans = allocateRoom(node * 2 + 1, rangeStart, mid, roomReq);
        else
            ans = allocateRoom(node * 2 + 2, mid + 1, rangeEnd, roomReq);

        segTree[node] = Math.max(segTree[node * 2 + 1], segTree[node * 2 + 2]);

        return ans;
    }
}
