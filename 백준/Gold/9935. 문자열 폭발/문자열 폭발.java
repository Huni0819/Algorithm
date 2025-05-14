import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String bomb = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : word.toCharArray()) {

            deque.offerLast(c);

            if (deque.size() < bomb.length() || deque.peekLast() != bomb.charAt(bomb.length() - 1)) {

                continue;
            }

            boolean flag = false;
            char[] arr = new char[bomb.length()];

            for (int i = bomb.length() - 1; i >= 0; i--) {

                arr[i] = deque.pollLast();

                if (arr[i] != bomb.charAt(i)) {

                    flag = true;
                }
            }

            if (flag) {

                for (char ch : arr) {

                    deque.offerLast(ch);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {

            sb.append(deque.pollFirst());
        }

        System.out.println(sb.toString().isEmpty() ? "FRULA" : sb);
    }
}