import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    static int N;
    static int M;

    static int[] arr;
    static int max = 0;

    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        visited = new boolean[N];

        Arrays.sort(arr);

        solution(0, 0);
        System.out.println(max);
    }

    static void solution(int dep, int sum) {

        if (dep == 3) {

            if (sum <= M) {

                max = Math.max(max, sum);
            }
            return;
        }

        for (int i = 0; i < N; i++) {

            if (!visited[i] && sum + arr[i] <= M) {
                visited[i] = true;
                solution(dep + 1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}