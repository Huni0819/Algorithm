import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static int V;
    static int E;

    static List<Node>[] lists;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        lists = new List[V + 1];

        for (int i = 1; i <= V; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {

            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);

            lists[A].add(new Node(B, C));
            lists[B].add(new Node(A, C));
        }

        System.out.println(solution());
    }

    static int solution() {

         int result = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w - o2.w;
            }
        });
        boolean[] visited = new boolean[V + 1];

        queue.offer(new Node(1, 0));

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (visited[now.x]) {
                continue;
            }

            visited[now.x] = true;
            result += now.w;

            for (Node next : lists[now.x]) {
                if (!visited[next.x]) {
                    queue.offer(next);
                }
            }
        }

        return result;
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