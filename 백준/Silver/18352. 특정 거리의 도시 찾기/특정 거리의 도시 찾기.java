import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int K;
    static int X;

    static List<Integer>[] lists;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        X = Integer.parseInt(input[3]);

        lists = new List[N + 1];

        for (int i = 1; i <= N; i++) {

            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            lists[A].add(B);
        }

        solution(X);
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num)
                    .append("\n");
        }

        System.out.println(result.isEmpty() ? -1 : sb);
    }

    static void solution(int start) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));

        boolean[] visited = new boolean[N + 1];
        visited[start] = true;

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (now.w == K) {
                result.add(now.x);
                continue;
            }

            for (int next : lists[now.x]) {

                if (visited[next]) {
                    continue;
                }

                queue.offer(new Node(next, now.w + 1));
                visited[next] = true;
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