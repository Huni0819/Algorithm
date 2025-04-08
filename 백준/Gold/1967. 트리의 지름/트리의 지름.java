import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int n;
    static List<Node>[] lists;
    static boolean[] leaf;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        lists = new List[n + 1];
        leaf = new boolean[n + 1];
        Arrays.fill(leaf, true);
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {

            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {

            String[] input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            int child = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            lists[parent].add(new Node(child, weight));
            lists[child].add(new Node(parent, weight));
            leaf[parent] = false;
        }

        for (int i = 1; i <= n; i++) {

            if (leaf[i]) {
                Arrays.fill(visited, false);
                solution(i, 0);
            }
        }

        System.out.println(max);
    }

    static void solution(int x, int sum) {

        visited[x] = true;
        max = Math.max(max, sum);

        for (Node next : lists[x]) {

            if (!visited[next.x]) {
                solution(next.x, sum + next.w);
            }
        }
    }
}

class Node {

    int x;
    int w;

    public Node(int x, int w) {
        this.x = x;
        this.w = w;
    }
}