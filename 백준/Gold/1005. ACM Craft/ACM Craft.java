import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[] delay;
    static boolean[] visited;
    static List<Integer>[] lists;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            delay = new int[N + 1];
            visited = new boolean[N + 1];
            lists = new List[N + 1];
            input = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {

                delay[i] = Integer.parseInt(input[i - 1]);
                lists[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {

                input = br.readLine().split(" ");
                int X = Integer.parseInt(input[0]);
                int Y = Integer.parseInt(input[1]);

                lists[Y].add(X);
            }

            int W = Integer.parseInt(br.readLine());

            sb.append(solution(W))
                    .append("\n");
        }

        System.out.println(sb);
    }

    static int solution(int W) {

        if (visited[W] || lists[W].isEmpty()) {
            return delay[W];
        }

        visited[W] = true;
        int max = 0;

        for (int prev : lists[W]) {

            max = Math.max(max, delay[W] + solution(prev));
        }

        return delay[W] = Math.max(max, delay[W]);
    }
}