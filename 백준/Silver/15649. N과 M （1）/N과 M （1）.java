import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;

    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N + 1];
        solution(0, new int[M]);

        System.out.print(sb);
    }

    static void solution(int dep, int[] arr) {

        if (dep == M) {

            for (int num : arr) {
                sb.append(num)
                        .append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            int[] temp = arr.clone();
            temp[dep] = i;
            solution(dep + 1, temp);
            visited[i] = false;
        }
    }
}