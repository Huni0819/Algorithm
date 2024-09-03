import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class  Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(reader.readLine());

        for (int i = 0; i < tc; i++) {

            String line = reader.readLine();

            solution(line);
        }
    }

    private static void solution(String line) {

        Stack<Character> before = new Stack<>();
        Stack<Character> after = new Stack<>();

        for (char c : line.toCharArray()) {

            switch (c) {

                case '<':
                    if (!before.isEmpty()) {
                        after.push(before.pop());
                    }
                    break;
                case '>':
                    if (!after.isEmpty()) {
                        before.push(after.pop());
                    }
                    break;
                case '-':
                    if (!before.isEmpty()) {
                        before.pop();
                    }
                    break;
                default:
                    before.push(c);
            }
        }

        StringBuilder builder = new StringBuilder();

        while (!before.isEmpty()) {
            builder.append(before.pop());
        }

        builder.reverse();

        while (!after.isEmpty()) {
            builder.append(after.pop());
        }

        System.out.println(builder);
    }
}