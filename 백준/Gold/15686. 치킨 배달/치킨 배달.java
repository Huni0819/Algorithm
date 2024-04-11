import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j < n+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(1, 1, 0);

        System.out.println(min);
    }

    private static void solution(int x, int y, int depth) {
        if (depth == m && depth > 0) {
            calc();

            if (depth == m) {
                return;
            }
        }

        for (int i = x; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (arr[i][j] == 2 && !visited[i][j]) {
                    visited[i][j] = true;
                    solution(i, j, depth+1);
                    visited[i][j] = false;
                }
            }
        }
    }

    private static void calc() {
        int sum = 0;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (arr[i][j] == 1) {
                    sum += minCh(i, j);
                }
            }
        }

        min = Math.min(min, sum);
    }

    private static int minCh(int x, int y) {
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (visited[i][j] && arr[i][j] == 2) {
                    int distance = Math.abs(x-i) + Math.abs(j-y);
                    if (distance == 1) {
                        return distance;
                    }
                    result = Math.min(result, distance);
                }
            }
        }

        return result;
    }
}