import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {

            queue.offer(i);
        }

        sb.append("<");

        int count = 0;
        StringJoiner joiner = new StringJoiner(", ");
        while (!queue.isEmpty()) {

            count++;

            if (count == K) {

                joiner.add(Integer.toString(queue.poll()));
                count = 0;
            } else if (count < K) {
                queue.offer(queue.poll());
            }
        }

        sb.append(joiner);
        sb.append(">");

        System.out.println(sb);
    }
}