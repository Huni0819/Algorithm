import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int K;

    static int[] arr = new int[100_001];

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        arr[N] = 1;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            if (now == K) {
                break;
            }

            if (now * 2 <= 100_000 && arr[now*2] == 0) {
                queue.offer(now*2);
                arr[now*2] = arr[now];
            }

            if (now - 1 >= 0 && arr[now-1] == 0) {
                queue.offer(now-1);
                arr[now-1] = arr[now] + 1;
            }

            if (now + 1 <= 100_000 && arr[now+1] == 0) {
                queue.offer(now+1);
                arr[now+1] = arr[now] + 1;
            }
        }

        System.out.println(arr[K]-1);
    }
}