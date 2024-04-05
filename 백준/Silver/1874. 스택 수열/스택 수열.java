import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    static final String PLUS = "+";
    static final String MINUS = "-";
    static final String NO = "NO";

    public static void main(String[] args) throws Exception {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        writer.write(solution(array));
        writer.flush();

        reader.close();
        writer.close();
    }

    private static String solution(int[] array) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int current = 1;
        for (Integer num : array) {

            if (current <= num) {

                while (current <= num) {
                    stack.push(current++);
                    builder.append(PLUS).append("\n");
                }

                stack.pop();
                builder.append(MINUS).append("\n");
            } else {

                if (stack.isEmpty() || stack.peek() > num) {
                    return NO;
                }

                stack.pop();
                builder.append(MINUS).append("\n");
            }
        }

        return builder.toString();
    }
}