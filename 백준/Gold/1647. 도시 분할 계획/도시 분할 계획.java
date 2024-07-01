import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int[] arr;
    static ArrayList<Road>[] list;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        arr = new int[N+1];
        list = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            line = reader.readLine().split(" ");

            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            list[a].add(new Road(b, c));
            list[b].add(new Road(a, c));
        }

        int result = solution(1);

        System.out.println(result);
    }

    private static int solution(int num) {
        boolean visited[] = new boolean[arr.length];
        PriorityQueue<Road> queue = new PriorityQueue<>(new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                return o1.weight - o2.weight;
            }
        });
        queue.offer(new Road(num, 0));

        int max = Integer.MIN_VALUE;
        int result = 0;
        while (!queue.isEmpty()) {
            Road now = queue.poll();

            if (visited[now.num]) {
                continue;
            }

            visited[now.num] = true;
            result += now.weight;

            max = Math.max(max, now.weight);

            for (Road next : list[now.num]) {

                if (!visited[next.num]) {
                    queue.offer(next);
                }
            }
        }

        return result - max;
    }
}

class Road {

    int num;
    int weight;

    public Road(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }
}