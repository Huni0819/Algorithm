import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int X;

    static List<Town>[] lists;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        X = Integer.parseInt(input[2]);

        lists = new List[N + 1];

        for (int i = 1; i <= N; i++) {

            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int t = Integer.parseInt(input[2]);

            lists[s].add(new Town(e, t));
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {

            if (i == X) {
                continue;
            }

            int sum = solution(i, X) + solution(X, i);
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }

    static int solution(int s, int e) {

        PriorityQueue<Town> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        queue.offer(new Town(s, 0));

        int[] d = new int[N + 1];
        Arrays.fill(d, 1_000_000_000);
        d[s] = 0;

        while (!queue.isEmpty()) {

            Town now = queue.poll();

            if (now.x == e) {

                return now.w;
            }

            for (Town next : lists[now.x]) {

                if (d[next.x] > d[now.x] + next.w) {

                    d[next.x] = d[now.x] + next.w;
                    queue.offer(new Town(next.x, d[next.x]));
                }
            }
        }

        return 0;
    }
}

class Town {

    int x;
    int w;

    public Town(int x, int w) {
        this.x = x;
        this.w = w;
    }
}