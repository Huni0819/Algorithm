import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int K;

    static int[] arr = new int[100_001];

    static int min = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        solution();

        if (N == K) {

            System.out.println(0 + "\n" + 1);
            return;
        }

        System.out.println(min + "\n" + count);
    }

    static void solution() {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N);
        arr[N] = 1;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            if (arr[now] > min) {
                return;
            }

            for (int i = 0; i < 3; i++) {

                int next = now + (i == 0 ? -1 : (i == 1 ? 1 : now));

                if (next < 0 || next > 100_000) {
                    continue;
                }

                if (next == K) {

                    min = arr[now];
                    count++;
                }

                if (arr[next] == 0 || arr[next] == arr[now] + 1) {

                    queue.offer(next);
                    arr[next] = arr[now] + 1;
                }
            }
        }
    }
}