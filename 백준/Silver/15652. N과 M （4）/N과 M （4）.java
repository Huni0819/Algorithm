import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[M];

        solution(1, 0);
        System.out.println(sb);
    }

    static void solution(int idx, int dep) {

        if (dep == M) {

            for (int num : arr) {

                sb.append(num)
                        .append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = idx; i <= N; i++) {

            arr[dep] = i;
            solution(i, dep + 1);
        }
    }
}