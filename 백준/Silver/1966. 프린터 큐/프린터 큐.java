import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(reader.readLine());

            int size = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < size; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            solution(queue, target);
        }
    }

    private static void solution(Queue<Integer> queue, int target) {
        int count = 0;

        while (!(target == 0 && checkMax(queue))) {
            if (checkMax(queue)) {
                queue.poll();
                count++;
            } else {
                queue.offer(queue.poll());
            }

            if (target == 0) {
                target = queue.size() - 1;
            } else {
                target--;
            }
        }

        System.out.println(++count);
    }

    private static boolean checkMax(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return false;
        }

        int target = queue.peek();

        return target >= queue.stream().max(Comparator.comparingInt(x -> x)).get();
    }
}