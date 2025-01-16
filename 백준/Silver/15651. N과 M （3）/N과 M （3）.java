import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int M;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        solution(0, new int[0]);

        System.out.print(sb);
    }

    static void solution(int depth, int[] arr) {

        if (depth == M) {

            for (int num : arr) {
                sb.append(num)
                        .append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {

                int[] temp = Arrays.copyOf(arr, arr.length + 1);
                temp[depth] = i;
                solution(depth + 1, temp);
        }
    }
}