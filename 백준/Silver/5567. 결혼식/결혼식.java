import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int n;
    static int m;
    static List<Integer>[] lists;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        lists = new List[n + 1];

        for (int i = 1; i <= n; i++) {

            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {

            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            lists[a].add(b);
            lists[b].add(a);
        }

        System.out.println(solution(1));
    }

    static int solution(int a) {

        Queue<Friend> queue = new LinkedList<>();
        queue.offer(new Friend(a, 0));

        boolean[] visited = new boolean[n + 1];
        visited[a] = true;

        int count = 0;

        while(!queue.isEmpty()) {

            Friend now = queue.poll();

            if (now.step >= 2) {
                continue;
            }

            for (int next : lists[now.x]) {

                if (visited[next]) {
                    continue;
                }

                queue.offer(new Friend(next, now.step + 1));
                visited[next] = true;
                count++;
            }
        }

        return count;
    }
}

class Friend {

    int x;
    int step;

    public Friend(int x, int step) {
        this.x = x;
        this.step = step;
    }
}