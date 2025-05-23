import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int R;
    static Integer[] result;

    static List<Integer>[] lists;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        lists = new List[N + 1];
        result = new Integer[N + 1];

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
            Collections.reverse(lists[i]);
        }

        solution(R);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {

            sb.append(Objects.isNull(result[i]) ? 0 : result[i])
                    .append("\n");
        }

        System.out.println(sb);
    }

    static void solution(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        int idx = 0;
        result[start] = ++idx;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            for (int num : lists[now]) {

                if (Objects.isNull(result[num])) {

                    result[num] = ++idx;
                    queue.offer(num);
                }
            }
        }
    }
}