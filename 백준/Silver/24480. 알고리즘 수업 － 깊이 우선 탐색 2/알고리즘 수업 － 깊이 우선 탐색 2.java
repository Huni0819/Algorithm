import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {

    static int N;
    static int M;
    static int R;
    static int count = 1;

    static List<Integer>[] lists;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        lists = new List[N + 1];
        visited = new int[N + 1];

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

        for (int i = 1; i <= N; i++) {

            sb.append(visited[i])
                    .append("\n");
        }

        System.out.println(sb);
    }

    static void solution(int idx) {

        visited[idx] = count++;

        for (int next : lists[idx]) {

            if (visited[next] == 0) {

                solution(next);
            }
        }
    }
}
