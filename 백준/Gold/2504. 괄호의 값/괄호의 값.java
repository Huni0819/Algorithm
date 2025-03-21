import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        Deque<Character> deque = new ArrayDeque<>();

        int result = 0;
        int value = 1;
        boolean flag = true;
        for (int i = 0; i < input.length; i++) {

            char c = input[i];

            if (c == '(' || c == '[') {

                deque.offerLast(c);
                value *= c == '(' ? 2 : 3;
            } else {

                if (deque.isEmpty() || (c == ')' && deque.peekLast() != '(') || (c == ']' && deque.peekLast() != '[')) {

                    flag = false;
                    break;
                }

                if ((c == ')' && input[i - 1] == '(') || (c == ']' && input[i - 1] == '[')) {

                    result += value;
                }

                deque.pollLast();
                value /= c == ')' ? 2 : 3;
            }
        }

        System.out.println(!deque.isEmpty() || !flag ? 0 : result);

    }
}