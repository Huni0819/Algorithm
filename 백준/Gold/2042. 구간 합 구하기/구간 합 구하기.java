import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int K;

    static long[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        arr = new long[N + 1];

        for (int i = 1; i <= N; i++) {

            arr[i] = Long.parseLong(br.readLine());
        }

        Tree tree = new Tree(N);
        tree.init(arr, 1, 1, N);

        for (int i = 0; i < M + K; i++) {

            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            long c = Long.parseLong(input[2]);

            if (a == 1) {

                tree.modify(1, 1, N, b, c - arr[b]);
                arr[b] = c;
            } else {

                sb.append(tree.sum(1, 1, N, b, (int) c))
                        .append("\n");
            }
        }

        System.out.println(sb);
    }
}

class Tree {

    long[] tree;
    int size;

    public Tree(int size) {

        int h = (int) Math.ceil(Math.log(size) / Math.log(2));

        this.size = (int) Math.pow(2, h + 1);
        tree = new long[this.size];
    }

    public long init(long[] arr, int node, int s, int e) {

        if (s == e) {
            return tree[node] = arr[s];
        }

        return tree[node] = init(arr, node * 2, s, (s + e) / 2) + init(arr, node * 2 + 1, (s + e) / 2 + 1, e);
    }

    public void modify(int node, int s, int e, int idx, long num) {

        if (idx < s || e < idx) {
            return;
        }

        tree[node] += num;

        if (s != e) {

            modify(node * 2, s, (s + e) / 2, idx, num);
            modify(node * 2 + 1, (s + e) / 2 + 1, e, idx, num);
        }
    }

    public long sum (int node, int s, int e, int l, int r) {

        if (l > e || r < s) {
            return 0;
        }

        if (l <= s && e <= r) {
            return tree[node];
        }

        return sum(node * 2, s, (s + e) / 2, l, r) + sum(node * 2 + 1, (s + e) / 2 + 1, e, l, r);

    }
}