import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int R;

    static Integer[] arr;
    static List<Integer>[] lists;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        arr = new Integer[N + 1];
        lists = new List[N + 1];

        for (int i = 1; i <= N; i++) {

            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            input = br.readLine().split(" ");

            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            lists[u].add(v);
            lists[v].add(u);
        }

        for (int i = 1; i <= N; i++) {

            Collections.sort(lists[i]);
        }

        solution();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {

            sb.append(Objects.nonNull(arr[i]) ? arr[i] : 0)
                    .append("\n");
        }

        System.out.println(sb);
    }

    static void solution() {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(R);
        arr[R] = 1;

        int count = 2;
        while (!queue.isEmpty()) {

            int now = queue.poll();

            for (int next : lists[now]) {

                if (Objects.nonNull(arr[next])) {
                    continue;
                }

                queue.offer(next);
                arr[next] = count++;
            }
        }
    }
}