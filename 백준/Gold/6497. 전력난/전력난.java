import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while (true) {

            st = new StringTokenizer(reader.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) {
                break;
            }

            int sum = 0;
            List<ArrayList<House>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(reader.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                list.get(x).add(new House(y, z));
                list.get(y).add(new House(x, z));

                sum += z;
            }

            System.out.println(sum - solution(list));

        }


    }

    private static int solution(List<ArrayList<House>> list) {
        PriorityQueue<House> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        for (House house : list.get(0)) {
            queue.offer(house);
        }

        boolean[] visited = new boolean[list.size()];
        visited[0] = true;

        int minSum = 0;
        while (!queue.isEmpty()) {
            House house = queue.poll();

            if (visited[house.x]) {
                continue;
            }

            visited[house.x] = true;
            minSum += house.weight;

            for (House next : list.get(house.x)) {
                queue.offer(next);
            }

        }

        return minSum;
    }
}

class House {

    int x;
    int weight;

    public House(int x, int weight) {
        this.x = x;
        this.weight = weight;
    }
}