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
        arr = new int[n][3];
        calc = new int[n][3];



        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());

        reader.close();
    }

    private static int solution() {
        calc[0][0] = arr[0][0];
        calc[0][1] = arr[0][1];
        calc[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                calc[i][j] = Math.min(calc[i-1][(j+1)%3], calc[i-1][(j+2)%3]) + arr[i][j];
            }
        }

        return Math.min(Math.min(calc[n-1][0], calc[n-1][1]), calc[n-1][2]);
    }
}