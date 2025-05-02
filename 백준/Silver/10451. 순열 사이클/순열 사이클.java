import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            int N = Integer.parseInt(br.readLine());

            arr = new int[N + 1];
            visited = new boolean[N + 1];

            String[] line = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {

                arr[i] = Integer.parseInt(line[i - 1]);
            }

            int count = 0;
            for (int i = 1; i <= N; i++) {

                if (!visited[i]) {

                    solution(i);
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    static void solution(int s) {

        visited[s] = true;

        if (!visited[arr[s]]) {

            solution(arr[s]);
        }
    }
}