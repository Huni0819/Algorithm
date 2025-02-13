import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            String[] input = br.readLine().split(" ");

            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            sb.append(solution(A, B))
                    .append("\n");
        }

        System.out.println(sb);
    }

    static String solution(int a, int b) {

        String result = "";

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(a, ""));

        boolean[] visited = new boolean[10_000];
        visited[a] = true;

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (now.n == b) {

                result = now.command;
                break;
            }

            int d = (now.n * 2) % 10000;

            if (!visited[d]) {

                queue.offer(new Node(d, now.command + "D"));
                visited[d] = true;
            }

            int s = now.n == 0 ? 9999 : now.n - 1;

            if (!visited[s]) {

                queue.offer(new Node(s, now.command + "S"));
                visited[s] = true;
            }

            int l = (now.n % 1000) * 10 + now.n / 1000;

            if (!visited[l]) {

                queue.offer(new Node(l, now.command + "L"));
                visited[l] = true;
            }

            int r = (now.n % 10) * 1000 + now.n / 10;

            if (!visited[r]) {

                queue.offer(new Node(r, now.command + "R"));
                visited[r] = true;
            }
        }

        return result;
    }
}

class Node {

    int n;
    String command;

    public Node(int n, String command) {
        this.n = n;
        this.command = command;
    }
}