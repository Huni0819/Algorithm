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
        calc[0][0] = arr[0][0];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j <= i; j++) {
                calc[i][j] = maxCalc(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, calc[n-1][i]);
        }

        return max;
    }

    private static int maxCalc(int x, int y) {

        if (y == 0) {
            calc[x][y] = calc[x-1][y] + arr[x][y];
        } else if (x == y) {
            calc[x][y] = calc[x-1][y-1] + arr[x][y];
        } else {
            calc[x][y] = Math.max(calc[x-1][y-1], calc[x-1][y]) + arr[x][y];
        }

        return calc[x][y];
    }
}