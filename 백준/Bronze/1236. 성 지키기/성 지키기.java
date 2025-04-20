import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        char[][] arr = new char[N][M];

        for (int i = 0; i < N; i++) {

            String line = br.readLine();

            for (int j = 0; j < M; j++) {

                arr[i][j] = line.charAt(j);
            }
        }

        int xCount = 0;
        for (int i = 0; i < N; i++) {

            boolean flag = true;
            for (int j = 0; j < M; j++) {

                if (arr[i][j] == 'X') {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                xCount++;
            }
        }

        int yCount = 0;
        for (int i = 0; i < M; i++) {

            boolean flag = true;
            for (int j = 0; j < N; j++) {

                if (arr[j][i] == 'X') {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                yCount++;
            }
        }

        System.out.println(Math.max(xCount, yCount));
    }
}