import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[100_001];
        int[] prev = new int[100_001];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        arr[n] = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if (now == m) {
                System.out.println(arr[now]-1);
                break;
            }

            if (now - 1 >= 0 && arr[now-1] == 0) {
                queue.offer(now-1);
                arr[now-1] = arr[now] + 1;
                prev[now-1] = now;
            }

            if (now + 1 <= 100_000 && arr[now+1] == 0) {
                queue.offer(now+1);
                arr[now+1] = arr[now] + 1;
                prev[now+1] = now;
            }

            if (now * 2 <= 100_000 && arr[now*2] == 0) {
                queue.offer(now*2);
                arr[now*2] = arr[now] + 1;
                prev[now*2] = now;
            }

        }

        int index = m;
        List<Integer> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        while (index != n) {
            list.add(index);
            index = prev[index];
        }

        Collections.reverse(list);

        builder.append(n).append(" ");
        list.stream().forEach(num -> builder.append(num).append(" "));

        System.out.print(builder);
        reader.close();
    }
}
