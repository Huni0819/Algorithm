import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;

    static boolean[] visited;
    static PriorityQueue<Dict> queue;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            visited = new boolean[n+1];

            queue = new PriorityQueue<>(new Comparator<Dict>() {
                @Override
                public int compare(Dict o1, Dict o2) {
                    if (o1.getB() == o2.getB()) {
                        return o1.getA() - o2.getA();
                    }

                    return o1.getB() - o2.getB();
                }
            });

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(reader.readLine());
                queue.offer(new Dict(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            int count = 0;

            while (!queue.isEmpty()) {
                Dict now = queue.poll();

                for (int i = now.getA(); i <= now.getB(); i++) {
                    if (!visited[i]) {
                        count++;
                        visited[i] = true;
                        break;
                    }
                }
            }

            System.out.println(count);

        }

        reader.close();
    }
}

class Dict {

    private int a;
    private int b;

    public Dict(int a, int b) {
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