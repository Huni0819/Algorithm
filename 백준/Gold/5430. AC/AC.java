import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            String command = reader.readLine();

            int n = Integer.parseInt(reader.readLine());

            String arrayString = reader.readLine();

            Deque<Integer> deque = parse(n, arrayString);

            solution(command, deque);
        }

        reader.close();
    }

    private static Deque<Integer> parse(int n, String string) {
        if (n == 0) {
            return new LinkedList<>();
        }

        Deque<Integer> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(string.substring(1, string.length() - 1), ", ");

        for (int i = 0; i < n; i++) {
            deque.add(Integer.parseInt(st.nextToken()));
        }

        return deque;
    }

    private static void solution(String command, Deque<Integer> deque) {
        boolean state = true;
        for (char c : command.toCharArray()) {

            if (c == 'R') {
                state = !state;
            } else {
                if (deque.isEmpty()) {
                    System.out.println("error");
                    return;
                }

                if (state) {
                    deque.removeFirst();
                } else {
                    deque.removeLast();
                }

            }
        }

        print(deque, state);
    }

    private static void print(Deque<Integer> deque, boolean state) {
        StringBuilder builder = new StringBuilder();

        List<Integer> list = deque.stream().collect(Collectors.toList());

        if (!state) {
            Collections.reverse(list);
        }

        builder.append("[")
                .append(String.join(",", list.stream()
                        .map(num -> Integer.toString(num))
                        .collect(Collectors.toList())))
                .append("]");

        System.out.println(builder);
    }
}