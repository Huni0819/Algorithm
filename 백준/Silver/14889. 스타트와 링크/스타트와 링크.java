import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        arr = new int[n][n];
        visited = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0);
        System.out.println(min);
        reader.close();
    }

    private static void solution(int index, int depth) {
        if (depth == n / 2) {
            calc();
            return;
        }

        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solution(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    private static void calc() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                if (visited[i] && visited[j]) {
                    start += arr[i][j] + arr[j][i];
                }

                if (!visited[i] && !visited[j]) {
                    link += arr[i][j] + arr[j][i];
                }
            }
        }

        int result = start - link;
        min = Math.min(min, Math.abs(result));
    }
}