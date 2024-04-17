import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int count = 0;
    static int[] seconds = new int[100_001];

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(seconds, 0);
        
        if (n == k) {
            System.out.println(0);
            System.exit(0);
        }
        
        solution(n);

        reader.close();
    }

    private static void solution(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        seconds[n] = 1;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next = num;

                if (i == 0) {
                    next += 1;
                } else if (i == 2) {
                    next -= 1;
                } else {
                    next *= 2;
                }

                if (next == k) {
                    System.out.println(seconds[num]);
                    return;
                }

                if ((next < 0 || next > 100_000) || seconds[next] != 0) {
                    continue;
                }

                queue.offer(next);
                seconds[next] = seconds[num] + 1;
            }
        }
    }
}