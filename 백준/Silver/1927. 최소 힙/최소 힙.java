import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());

            if (num == 0) {
                System.out.println(queue.isEmpty() ? 0 : queue.poll());
            } else {
                queue.offer(num);
            }
        }

        reader.close();
    }
}