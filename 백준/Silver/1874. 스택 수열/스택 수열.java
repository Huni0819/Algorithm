import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;
        int index = 0;
        for (int i = 0; i < N; i++) {

            while (deque.isEmpty() || deque.peekLast() != arr[index]) {

                if (num == N+1) {
                    break;
                }

                deque.offerLast(num);
                num++;
                builder.append("+")
                        .append("\n");
            }

            if (deque.peekLast() == arr[index]) {
                deque.pollLast();
                index++;
                builder.append("-")
                        .append("\n");
            }
        }

        System.out.println(deque.isEmpty() ? builder : "NO");
    }
}