import java.io.*;
import java.util.*;

public class Main {

    static int V;
    static int E;

    static List<Node>[] list;
    static Integer[] visited;

    static StringBuilder builder = new StringBuilder();

    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        int start = Integer.parseInt(br.readLine());

        visited = new Integer[V+1];
        list = new List[V+1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");

            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            list[u].add(new Node(v, w));
        }

        solution(start);

        for (int i = 1; i <= V; i++) {
            builder.append(visited[i] == null ? "INF" : visited[i])
                .append("\n");
        }

        System.out.print(builder);
    }

    static void solution(int n) {

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<>() {

            public int compare(Node o1, Node o2) {

                if (o1.weight == o2.weight) {
                    return o1.x - o2.x;
                }

                return o1.weight - o2.weight;
            }
        });

        queue.offer(new Node(n, 0));

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (visited[now.x] != null) {
                continue;
            }

            visited[now.x] = now.weight;

            for (Node next : list[now.x]) {

                if (visited[next.x] == null) {
                    queue.offer(new Node(next.x, next.weight + now.weight));
                }
            }
        }
        
    }
}

class Node {

    int x;
    int weight;

    public Node(int x, int weight) {
        this.x = x;
        this.weight = weight;
    }
}