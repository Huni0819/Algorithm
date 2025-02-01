import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;

    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N + 1];

        solution(0, 1);

        System.out.println(sb);
    }

    static void solution(int dep, int idx) {

        if (dep == M) {

            for (int i = 1; i <= N; i++) {

                if (visited[i]) {
                    sb.append(i)
                            .append(" ");
                }
            }

            sb.append("\n");
            return;
        }

        for (int i = idx; i <= N; i++) {

            if (!visited[i]) {

                visited[i] = true;
                solution(dep + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}