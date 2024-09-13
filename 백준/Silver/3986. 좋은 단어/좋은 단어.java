import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String line = reader.readLine();

            for (char c : line.toCharArray()) {

                stack.push(c);

                if (stack.size() >= 2) {
                    char a = stack.pop();

                    char b = stack.peek();

                    if (a == b) {
                        stack.pop();
                    } else {
                        stack.push(a);
                    }
                }
            }

            if (stack.isEmpty()) {
                count++;
            }
        }


        System.out.println(count);

    }
}