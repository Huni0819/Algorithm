import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int V;
    static int maxIdx = 0;
    static int max = Integer.MIN_VALUE;

    static List<Node>[] lists;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        lists = new List[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {

            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {

            String[] input = br.readLine().split(" ");
            int idx = 0;

            int nNum = Integer.parseInt(input[idx++]);

            while (Integer.parseInt(input[idx]) != -1) {

                int x = Integer.parseInt(input[idx++]);
                int w = Integer.parseInt(input[idx++]);

                lists[nNum].add(new Node(x, w));
            }
        }

        solution(1, 0);

        Arrays.fill(visited, false);
        solution(maxIdx, 0);

        System.out.println(max);
    }

    static void solution(int idx, int sum) {

        if (sum > max) {

            max = sum;
            maxIdx = idx;
        }

        visited[idx] = true;
        for (Node next : lists[idx]) {

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