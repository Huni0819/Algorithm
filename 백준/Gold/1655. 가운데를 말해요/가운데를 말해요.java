import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());

            if (i % 2 == 0) {
                maxQueue.offer(num);
            } else {
                minQueue.offer(num);
            }

            if (i == 0) {
                builder.append(maxQueue.peek()).append("\n");
                continue;
            }

            if (maxQueue.peek() > minQueue.peek()) {
                minQueue.offer(maxQueue.poll());
                maxQueue.offer(minQueue.poll());
            }

            builder.append(maxQueue.peek()).append("\n");
        }

        writer.write(builder.toString());
        writer.flush();
        reader.close();
        writer.close();
    }

}