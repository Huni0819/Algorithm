import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();
        long count = 0;

        for (int i = 0; i < N; i++) {

            int h = Integer.parseInt(reader.readLine());

            while (!stack.isEmpty()) {
                if (stack.peek() <= h) {
                    stack.pop();
                } else {
                    break;
                }
            }

            count += stack.size();
            stack.push(h);
        }

        System.out.println(count);
    }
}