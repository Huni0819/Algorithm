import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] arr = new int[100_001][2]; // arr[0] -> 시간, arr[1] -> 이전 위치

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        arr[N][0] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                builder.append(arr[now][0] - 1)
                        .append("\n");

                int[] trace = new int[arr[now][0]];

                int num = now;
                for (int i = trace.length - 1; i >= 0; i--) {

                    trace[i] = num;
                    num = arr[num][1];
                }

                Arrays.stream(trace)
                        .forEach(x -> builder.append(x).append(" "));

                break;
            }

            if (now + 1 <= 100_000 && arr[now + 1][0] == 0) {
                queue.offer(now + 1);
                arr[now + 1][0] = arr[now][0] + 1;
                arr[now + 1][1] = now;
            }

            if (now - 1 >= 0 && arr[now - 1][0] == 0) {
                queue.offer(now - 1);
                arr[now - 1][0] = arr[now][0] + 1;
                arr[now - 1][1] = now;
            }

            if (now * 2 <= 100_000 && arr[now * 2][0] == 0) {
                queue.offer(now * 2);
                arr[now * 2][0] = arr[now][0] + 1;
                arr[now * 2][1] = now;
            }
        }

        System.out.println(builder);

    }
}