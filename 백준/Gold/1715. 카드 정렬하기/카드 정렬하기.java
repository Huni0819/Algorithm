import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(reader.readLine()));
        }

        System.out.println(solution(queue));

        reader.close();
    }

    private static int solution(PriorityQueue<Integer> queue) {

        if (queue.size() == 1) {
            return 0;
        }

        int sum = 0;
        while (queue.size() > 1) {
            int num = queue.poll() + queue.poll();
            sum += num;

            queue.offer(num);
        }

        return sum;
    }
}