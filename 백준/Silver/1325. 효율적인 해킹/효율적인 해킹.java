import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static List<Integer>[] lists;
    static int[] count;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        lists = new List[N + 1];
        count = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            lists[B].add(A);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {

            solution(i);
            max = Math.max(max, count[i]);
        }

        for (int i = 1; i <= N; i++) {

            if (max == count[i]) {
                sb.append(i)
                        .append(" ");
            }
        }

        System.out.println(sb);
    }

    static void solution(int X) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        visited[X] = true;
        queue.offer(X);

        while (!queue.isEmpty()) {

            int now = queue.poll();

            for (int next : lists[now]) {

                if (!visited[next]) {

                    queue.offer(next);
                    visited[next] = true;
                    count[X]++;
                }
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