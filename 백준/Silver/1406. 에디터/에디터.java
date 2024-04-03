import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Stack<Character> before = new Stack<>();
    private static Stack<Character> after = new Stack<>();

    public static void main(String[] args) throws Exception {

        String line = reader.readLine();

        for (char c : line.toCharArray()) {
            before.push(c);
        }

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            switch (st.nextToken()) {
                case "L":
                    if (!before.empty())
                        after.push(before.pop());
                    break;
                case "D":
                    if (!after.empty()) {
                        before.push(after.pop());
                    }
                    break;
                case "B":
                    if (!before.empty())
                        before.pop();
                    break;
                default:
                    before.push(st.nextToken().charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!before.empty()) {
            sb.append(before.pop());
        }

        sb.reverse();

        while (!after.empty()) {
            sb.append(after.pop());
        }

        writer.write(sb.toString());
        writer.flush();
    }
}