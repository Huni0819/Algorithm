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

        calc[0][0] = arr[0][0];
        calc[0][1] = arr[0][1];
        calc[0][2] = arr[0][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(Math.min(Math.min(solution(n-1, 0), solution(n-1, 1)), solution(n-1, 2)));

        reader.close();
    }

    private static int solution(int num, int color) {

        if (num < 0) {
            return 0;
        }

        if (calc[num][color] == 0) {

            if (color == 0) {
                calc[num][color] =
                        Math.min(solution(num-1, 1), solution(num-1, 2)) +
                                arr[num][color];
            } else if (color == 1) {
                calc[num][color] =
                        Math.min(solution(num-1, 0), solution(num-1, 2)) +
                                arr[num][color];
            } else {
                calc[num][color] =
                        Math.min(solution(num-1, 0), solution(num-1, 1)) +
                                arr[num][color];
            }
        }

        return calc[num][color];
    }
}