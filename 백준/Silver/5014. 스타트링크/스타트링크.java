import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int f; // 총 건물 층 수
    static int s; // 강호의 현재 위치
    static int g; // 강호가 도착해야하는 층 수
    static int u; // 한번에 올라가는 층 수
    static int d; // 한번에 내려가는 층 수
    static int[] visited; // 각 층 방문 여부


    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new int[f+1];

        solution();

        reader.close();
    }

    private static void solution() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == g) {
                System.out.println(visited[now]-1);
                System.exit(0);
            }

            if (now + u <= f && visited[now+u] == 0) {
                queue.offer(now+u);
                visited[now+u] = visited[now] + 1;
            }

            if (now - d >= 1 && visited[now-d] == 0) {
                queue.offer(now-d);
                visited[now-d] = visited[now] + 1;
            }
        }

        System.out.println("use the stairs");
    }
}