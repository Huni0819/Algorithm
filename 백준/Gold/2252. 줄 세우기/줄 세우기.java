import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> list = new ArrayList<>();
        int[] indegree = new int[n+1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            indegree[b]++;
        }

        StringBuilder builder = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                indegree[i]--;
                builder.append(i).append(" ");
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (list.get(num).isEmpty()) {
                continue;
            }

            for (int x : list.get(num)) {
                indegree[x]--;

                if (indegree[x] == 0) {
                    queue.offer(x);
                    builder.append(x).append(" ");
                }
            }
        }

        System.out.println(builder);
    }
}