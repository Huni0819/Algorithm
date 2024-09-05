import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();
        int T = Integer.parseInt(reader.readLine());

        for (int tc = 0; tc < T; tc++) {
            String P = reader.readLine();

            int N = Integer.parseInt(reader.readLine());

            String line = reader.readLine();
            line = line.substring(1, line.length() - 1);

            Deque<Integer> deque = new ArrayDeque<>();
            String[] arr = line.split(",");
            for (int i = 0; i < N; i++) {
                deque.offer(Integer.parseInt(arr[i]));
            }

            builder.append(solution(P, deque)).append("\n");
        }

        System.out.println(builder);
    }

    private static String solution(String P, Deque<Integer> deque) {
        boolean direction = true;

        for (char c : P.toCharArray()) {
            switch (c) {
                case 'R':
                    direction = !direction;
                    break;
                case 'D':
                    if (deque.isEmpty()) {
                        return "error";
                    }

                    if (direction) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
            }
        }

        StringBuilder builder = new StringBuilder("[");
        StringJoiner joiner = new StringJoiner(",");
        while (!deque.isEmpty()) {
            joiner.add(Integer.toString(direction ? deque.pollFirst() : deque.pollLast()));
        }

        builder.append(joiner).append("]");

        return builder.toString();
    }
}