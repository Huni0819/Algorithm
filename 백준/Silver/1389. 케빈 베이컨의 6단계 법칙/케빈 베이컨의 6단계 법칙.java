import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static List<Integer>[] lists;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        lists = new List[N + 1];

        for (int i = 1; i <= N; i++) {

            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            input = br.readLine().split(" ");

            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            lists[A].add(B);
            lists[B].add(A);
        }

        int min = Integer.MAX_VALUE;
        int minNum = 1;
        for (int i = 1; i <= N; i++) {

            int friends = solution(i);
            if (min > friends) {
                min = friends;
                minNum = i;
            }
        }

        System.out.println(minNum);
    }

    static int solution(int num) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);

        Integer[] visited = new Integer[N + 1];
        visited[num] = 0;

        while(!queue.isEmpty()) {

            int now = queue.poll();

            for (int next : lists[now]) {

                if (Objects.nonNull(visited[next])) {
                    continue;
                }

                queue.offer(next);
                visited[next] = visited[now] + 1;
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {

            sum += visited[i];
        }

        return sum;
    }
}

