import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> before = new Stack<>();
        Stack<Character> after = new Stack<>();

        for (char c : reader.readLine().toCharArray()) {
            before.push(c);
        }

        int N = Integer.parseInt(reader.readLine());

        String[] input;
        for (int i = 0; i < N; i++) {

            input = reader.readLine().split(" ");

            switch (input[0]) {
                case "L":
                    if (!before.isEmpty()) {
                        after.push(before.pop());
                    }
                    break;
                case "D":
                    if(!after.isEmpty()) {
                        before.push(after.pop());
                    }
                    break;
                case "B":
                    if (!before.isEmpty()) {
                        before.pop();
                    }
                    break;
                case "P":
                    before.push(input[1].charAt(0));
                    break;
            }
        }

        while (!after.isEmpty()) {
            before.push(after.pop());
        }

        StringBuilder builder = new StringBuilder();

        while (!before.isEmpty()) {
            builder.append(before.pop());
        }

        System.out.println(builder.reverse());
    }
}