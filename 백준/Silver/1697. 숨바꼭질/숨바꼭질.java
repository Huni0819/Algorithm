import java.io.*;
import java.util.*;

public class Main {

    static int[] arr = new int[100_001];

    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        System.out.print(bfs(N, K));
    }

    static int bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        arr[n] = 1;
        queue.offer(n);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == k) {
                break;
            }

            if (now + 1 < 100_001 && arr[now + 1] == 0) {
                queue.offer(now + 1);
                arr[now + 1] = arr[now] + 1;
            }

            if (now - 1 >= 0 && arr[now - 1] == 0) {
                queue.offer(now - 1);
                arr[now - 1] = arr[now] + 1;
            }

            if (now * 2 < 100_001 && arr[now * 2] == 0) {
                queue.offer(now * 2);
                arr[now * 2] = arr[now] + 1;
            }
        }

        return arr[k] - 1;
    }
    
}