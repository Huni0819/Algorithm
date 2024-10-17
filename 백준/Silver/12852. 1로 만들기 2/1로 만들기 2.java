import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        N = Integer.parseInt(reader.readLine());
        arr = new int[N+1][2];

        int count = solution();

        builder.append(count)
                .append("\n");

        int index = 1;
        int[] trace = new int[count+1];

        for (int i = count; i >= 0; i--) {
            trace[i] = index;
            index = arr[index][1];
        }

        Arrays.stream(trace)
                .forEach(num -> builder.append(num)
                        .append(" "));

        System.out.print(builder);
    }

    static int solution() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        arr[N][0] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == 1) {
                return arr[now][0] - 1;
            }

            if (now % 3 == 0 && arr[now/3][0] == 0) {

                queue.offer(now/3);
                arr[now/3][0] = arr[now][0] + 1;
                arr[now/3][1] = now;
            }

            if (now % 2 == 0 && arr[now/2][0] == 0) {

                queue.offer(now/2);
                arr[now/2][0] = arr[now][0] + 1;
                arr[now/2][1] = now;
            }

            if (arr[now-1][0] == 0) {
                queue.offer(now-1);
                arr[now-1][0] = arr[now][0] + 1;
                arr[now-1][1] = now;
            }

        }

        return 0;
    }
}