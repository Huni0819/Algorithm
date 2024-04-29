import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        solution.input();
        solution.solution();
    }
}

class Solution {

    private int n;
    private int k;
    private boolean[] visited = new boolean[100_001];

    public void input() throws Exception {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        reader.close();
    }

    public void solution() {
        Deque<Location> deque = new ArrayDeque<>();
        visited[n] = true;
        deque.offerFirst(new Location(n, 0));

        while (!deque.isEmpty()) {
            Location now = deque.pollFirst();

            if (now.getX() == k) {
                System.out.println(now.getTime());
                return;
            }

            if (now.getX() < 0 || now.getX() > 100_000) {
                continue;
            }

            if (now.getX() * 2 > 0 && now.getX() * 2 < 100_001) {
                if (!visited[now.getX() * 2]) {
                    deque.offerFirst(new Location(now.getX() * 2, now.getTime()));
                    visited[now.getX() * 2] = true;
                }
            }

            if (now.getX() - 1 >= 0) {
                if (!visited[now.getX() - 1]) {
                    deque.offerLast(new Location(now.getX() - 1, now.getTime() + 1));
                    visited[now.getX() - 1] = true;
                }
            }

            if (now.getX() + 1 < 100_001) {
                if (!visited[now.getX() + 1]) {
                    deque.offerLast(new Location(now.getX() + 1, now.getTime() + 1));
                    visited[now.getX() + 1] = true;
                }
            }
        }
    }

}

class Location {

    private int x;
    private int time;

    public Location(int x, int time) {
        this.x = x;
        this.time = time;
    }

    public int getX() {
        return x;
    }

    public int getTime() {
        return time;
    }
}