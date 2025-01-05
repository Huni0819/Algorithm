import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] d;

    static List<Node>[] lists;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        lists = new List[N + 1];
        d = new int[N + 1];

        Arrays.fill(d, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            lists[Integer.parseInt(input[0])].add(
                    new Node(Integer.parseInt(input[1]), Integer.parseInt(input[2]))
            );
        }

        String[] input = br.readLine().split(" ");
        System.out.println(solution(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
    }

    static int solution(int s, int e) {

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

        boolean[] visited = new boolean[N + 1];
        queue.offer(new Node(s, 0));
        d[s] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (visited[now.x]) {
                continue;
            }

            visited[now.x] = true;

            for (Node next : lists[now.x]) {

                if (!visited[next.x] && d[next.x] > d[now.x] + next.w) {
                    d[next.x] = d[now.x] + next.w;
                    queue.offer(new Node(next.x, d[next.x]));
                }
            }
        }

        return d[e];
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