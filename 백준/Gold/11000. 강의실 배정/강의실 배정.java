import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Lecture[] arr = new Lecture[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            arr[i] = new Lecture(start, end);
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o.s));

        System.out.println(solution(arr));
    }

    static int solution(Lecture[] arr) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.offer(arr[0].e);

        for (int i = 1; i < arr.length; i++) {

            if (queue.peek() <= arr[i].s) {

                queue.poll();
            }

            queue.offer(arr[i].e);
        }

        return queue.size();
    }
}

class Lecture {

    int s;
    int e;

    public Lecture(int s, int e) {
        this.s = s;
        this.e = e;
    }
}