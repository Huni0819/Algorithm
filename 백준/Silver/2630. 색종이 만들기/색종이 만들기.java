import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    static int N;
    static int[][] arr;

    static int bC = 0;
    static int wC = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {

            arr[i] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        solution(0, 0, N);

        System.out.println(wC);
        System.out.println(bC);
    }

    static void solution(int x, int y, int size) {

        boolean flag = true;

        loop : for (int i = x; i < x + size; i++) {

            for (int j = y; j < y + size; j++) {

                if (arr[x][y] != arr[i][j]) {
                    flag = false;
                    break loop;
                }
            }
        }

        if (flag) {

            if (arr[x][y] == 1) {
                bC++;
            } else {
                wC++;
            }
        } else {

            solution(x, y, size / 2);
            solution(x, y + size / 2, size / 2);
            solution(x + size / 2, y, size / 2);
            solution(x + size / 2, y + size / 2, size / 2);
        }
    }
}