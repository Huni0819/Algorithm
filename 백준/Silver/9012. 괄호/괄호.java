import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        loop : for (int tc = 0; tc < T; tc++) {
            Stack<Character> stack = new Stack<>();
            String line = reader.readLine();

            for (char c : line.toCharArray()) {

                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {

                    if (stack.isEmpty()) {
                        builder.append("NO").append("\n");
                        continue loop;
                    } else {
                        stack.pop();
                    }
                }
            }

            builder.append(stack.isEmpty() ? "YES" : "NO").append("\n");
        }

        System.out.println(builder);
    }
}