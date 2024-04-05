import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            queue.offer(i+1);
        }

        int count = 0;
        int k = Integer.parseInt(st.nextToken());
        while (queue.size() > 0) {
            count++;

            if (count % k == 0) {
                result.add(queue.poll());
                continue;
            }

            queue.offer(queue.poll());
        }

        StringBuilder builder = new StringBuilder();
        builder.append("<");

        StringJoiner joiner = new StringJoiner(", ");

        result.forEach(num -> joiner.add(num.toString()));
        builder.append(joiner);

        builder.append(">");
        System.out.println(builder);
    }
}