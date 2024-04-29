import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        solution.input();
        solution.solution();
    }
}

class Solution {

    private int n;
    private Station[] stations;
    private int l;
    private int p;
    private int sum;
    private PriorityQueue<Station> queue = new PriorityQueue<>((o1, o2) -> o2.getB() - o1.getB());
    private static int count = 0;
    private static int distance = 0;

    public void input() throws Exception {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        stations = new Station[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            stations[i] = new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sum += stations[i].getB();
        }

        StringTokenizer st = new StringTokenizer(reader.readLine());
        l = Integer.parseInt(st.nextToken());
        stations[n] = new Station(l, 0);
        p = Integer.parseInt(st.nextToken());

        reader.close();
    }

    public void solution() {
        // 보유한 기름 + 주유소의 모든 기름으로 마을에 도달하지 못하는 경우
        if (p + sum < l) {
            System.out.println(-1);
            return;
        }

        // 거리순으로 주유소 정렬
        Arrays.sort(stations, new Comparator<Station>() {
            @Override
            public int compare(Station o1, Station o2) {
                return o1.getA() - o2.getA();
            }
        });

        for (int i = 0; i < n; i++) {
            p -= (stations[i].getA() - distance);
            queue.offer(stations[i]);

            int sub = stations[i + 1].getA() - stations[i].getA();

            while (!queue.isEmpty() && p < sub) {
                Station now = queue.poll();

                p += now.getB();
                count++;
            }
            
            if (queue.isEmpty() && p < sub) {
                System.out.println(-1);
                return;
            }

            distance = stations[i].getA();
        }

        System.out.println(count);
    }
}

class Station {
    private int a;
    private int b;

    public Station(int a, int b) {
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