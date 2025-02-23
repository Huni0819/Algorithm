import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[][] c = {
            {3, 1},
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2}
    };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(":");
        int H = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int min = Integer.MAX_VALUE;
        int h = 0;
        int m = 0;

        for (int i = 0; i < 100; i++) {

            for (int j = 0; j < 100; j++) {

                if (i % 24 != H || j % 60 != M) {
                    continue;
                }

                int e = solution(i / 10, i % 10) + solution(i % 10, j / 10) + solution(j / 10, j % 10);

                if (min > e) {
                    min = e;
                    h = i;
                    m = j;
                }
            }
        }

        System.out.format("%02d:%02d", h, m);
    }

    static int solution(int a, int b) {
        return Math.abs(c[a][0] - c[b][0]) + Math.abs(c[a][1] - c[b][1]);
    }
}