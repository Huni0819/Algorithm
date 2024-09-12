import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();


        loop : while (true) {
            stack.clear();
            String line = reader.readLine();

            if (line.equals(".")) {
                break;
            }

            for (char c : line.toCharArray()) {

                if (c == '(' || c == '[') {
                    stack.push(c);
                    continue;
                }

                if (!stack.isEmpty() && ((c == ')' && stack.peek() == '[') || (c == ']' && stack.peek() == '('))) {
                    builder.append("no").append("\n");
                    continue loop;
                } else if (!stack.isEmpty() && ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '['))) {
                    stack.pop();
                } else if ((c == ']' || c == ')') && stack.isEmpty()) {
                    builder.append("no").append("\n");
                    continue loop;
                }
            }

            builder.append(stack.isEmpty() ? "yes" : "no").append("\n");
        }

        System.out.println(builder);

    }
}