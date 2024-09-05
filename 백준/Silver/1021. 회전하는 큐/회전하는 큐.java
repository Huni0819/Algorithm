import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        input = reader.readLine().split(" ");
        int count = 0;
        for (int i = 0; i < M; i++) {
            int targetIndex = deque.indexOf(Integer.parseInt(input[i]));

            int mid = deque.size() / 2;

            if (deque.size() % 2 == 0) {
                mid--;
            }

            if (mid >= targetIndex) {
                for (int j = 0; j < targetIndex; j++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            } else {
                for (int j = 0; j < deque.size() - targetIndex; j++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(count);
    }


}