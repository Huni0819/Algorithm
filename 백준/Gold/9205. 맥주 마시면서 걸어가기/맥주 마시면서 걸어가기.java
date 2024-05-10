import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Coordinate[] arr;
    static List<Integer>[] lists;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(reader.readLine());

            arr = new Coordinate[n+2];
            lists = new List[n+2];

            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());

                arr[j] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                lists[j] = new ArrayList<>();
            }

            for (int j = 0; j < n+2; j++) {
                for (int k = j+1; k < n+2; k++) {

                    if (Math.abs(arr[j].getX() - arr[k].getX()) + Math.abs(arr[j].getY() - arr[k].getY()) <= 1000) {
                        lists[j].add(k);
                        lists[k].add(j);
                    }
                }
            }

            System.out.println(solution(arr, lists) ? "happy" : "sad");
        }

        reader.close();
    }

    private static boolean solution(Coordinate[] arr, List<Integer>[] lists) {
        boolean[] visited = new boolean[arr.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            if (now == arr.length-1) {
                return true;
            }

            for (int i = 0; i < lists[now].size(); i++) {
                if (!visited[lists[now].get(i)]) {
                    visited[lists[now].get(i)] = true;
                    queue.offer(lists[now].get(i));
                }
            }
        }

        return false;
    }
}

class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}