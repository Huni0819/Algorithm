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

        System.out.println(solution());
        reader.close();
    }

    private static int solution() {
        for (int i = 0; i < n; i++) {
            calc[n-1][i] = arr[n-1][i];
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                calc[i][j] = Math.max(calc[i+1][j], calc[i+1][j+1]) + arr[i][j];
            }
        }

        return calc[0][0];
    }


}