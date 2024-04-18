import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static int[][] calc;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        arr = new int[n][];
        calc = new int[n][];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[i+1];
            calc[i] = new int[i+1];

            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            calc[n-1][i] = arr[n-1][i];
        }

        System.out.println(solution(0, 0));
        reader.close();
    }

    private static int solution(int depth, int idx) {

        if (depth == n -1) {
            return calc[depth][idx];
        }

        if (calc[depth][idx] == 0) {
            calc[depth][idx] = Math.max(solution(depth + 1, idx),
                    solution(depth + 1, idx +1)) + arr[depth][idx];
        }

        return calc[depth][idx];
    }


}