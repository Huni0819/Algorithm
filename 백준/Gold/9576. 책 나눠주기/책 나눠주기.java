import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] book;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            book = new boolean[n+1];
            int[] count = new int[n+1];

            PriorityQueue<Range> queue = new PriorityQueue<>(m, (o1, o2) -> o1.getB() == o2.getB() ? o2.getA() - o1.getA() : o1.getB() - o2.getB());

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(reader.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                queue.offer(new Range(a, b));

                for (int k = a; k <= b; k++) {
                    count[i]++;
                }
            }

            System.out.println(solution(queue));
        }

        reader.close();
    }

    private static int solution(PriorityQueue<Range> queue) {
        int result = 0;

        while (!queue.isEmpty()) {
            Range now = queue.poll();

            for (int i = now.getA(); i <= now.getB(); i++) {
                if (!book[i]) {
                    book[i] = true;
                    result++;
                    break;
                }
            }
        }

        return result;
    }
}

class Range {
    private int a;
    private int b;

    public Range(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}