import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N + M];

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {

            arr[i + N] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr)
                .forEach(num -> sb.append(num)
                        .append(" "));

        System.out.println(sb);
    }
}