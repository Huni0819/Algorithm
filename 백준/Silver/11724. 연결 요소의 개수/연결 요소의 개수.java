import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static List<Integer>[] list;
    static boolean[] visited;

    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        list = new List[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");

            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            list[u].add(v);
            list[v].add(u);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {

            if (!visited[i]) {
                solution(i);
                count++;
            }
        }

        System.out.print(count);
    }

    static void solution(int idx) {

        Queue<Integer> queue = new LinkedList<>();
        visited[idx] = true;
        queue.offer(idx);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : list[now]) {

                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}