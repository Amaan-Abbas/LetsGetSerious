package graph.ReRooting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CompanyQueryII {
    static int N = 200005;
    static int log = 20;
    static ArrayList<Integer>[] tree;
    static int[][] up = new int[N][log];
    static int[] depth = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int u = Integer.parseInt(st.nextToken());

            tree[u].add(i);
            tree[i].add(u);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < log; j++) up[i][j] = -1;
        }

        dfs(1, -1);

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(lca(a, b));
        }
    }

    public static void dfs(int node , int parent)
    {
        up[node][0] = parent;
        for(int j =  1; j < log; j++)
        {
            if(up[node][j-1]!=-1)
            {
                up[node][j] = up[up[node][j-1]][j-1];
            }
            else {
                up[node][j] = -1;
            }
        }

        for(int child : tree[node])
        {
            if(child == parent)continue;
            depth[child] = depth[node]+1;
            dfs(child,node);
        }
    }

    public static int lift(int node, int k) // kth ancestor of node
    {
        for(int j = log-1; j>=0;j--)
        {
            if((k&(1<<j))!=0)
            {
                node = up[node][j];
                if(node == -1)
                    return -1;
            }
        }

        return node;
    }

    public static int lca(int a,  int b)  // lca of a and b
    {
        if(depth[a] < depth[b])
        {

            int temp = a;
            a = b;
            b = temp;
        }
        int diff = depth[a] - depth[b];

        a = lift(a,diff);
        if(a == b)
            return a;
        for(int j = log-1;j>=0;j--)
        {
            if(up[a][j]!=up[b][j])
            {

                a = up[a][j];
                b = up[b][j];
            }
        }
        return up[a][0];
    }
}
