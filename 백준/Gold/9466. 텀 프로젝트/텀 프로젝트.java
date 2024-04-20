import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static boolean[] done;
    static int count;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            done = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(reader.readLine());
            count = 0;

            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (!done[j]) {
                    solution(j);
                }
            }

            System.out.println(n - count);
        }

        reader.close();
    }

    private static void solution(int num) {

        if (visited[num]) {
            done[num] = true;
            count++;
        }

        visited[num] = true;

        if (!done[arr[num]]) {
            solution(arr[num]);
        }

        visited[num] = false;
        done[num] = true;



    }
}