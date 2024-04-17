import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int count = 0;
    static int n;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        list = new LinkedList[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            list[i] = new LinkedList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            list[one].add(two);
            list[two].add(one);
        }

        solution(1);

        System.out.println(count);
        reader.close();
    }

    private static void solution(int num) {
        Queue<Integer> queue = new LinkedList<>();
        visited[num] = true;
        queue.offer(num);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < list[now].size(); i++) {
                if (!visited[list[now].get(i)]) {
                    queue.offer(list[now].get(i));
                    visited[list[now].get(i)] = true;
                    count++;
                }
            }
        }
    }
}