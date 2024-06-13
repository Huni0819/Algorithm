import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 1 = 동, 2 = 서, 3 = 북, 4 = 남
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int n;
    static int m;
    static int x;
    static int y;
    static int k;

    static int[][] map;

    static StringTokenizer command;

    // 주사위 면의 초기 값은 모두 0.
    static int[] dice = new int[6];

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1 = 동, 2 = 서, 3 = 북, 4 = 남
        // dx[command-1], dy[command-1]로 이동
        command = new StringTokenizer(reader.readLine());

        // 이동한 칸에 있는 수가 0이면 주사위 바닥에 있는 수가 칸에 복사.
        // 0이 아닌 경우 칸에 있는 수가 주사위 바닥에 복사
        // 복사는 바닥에, 출력은 윗 면에 쓰여 있는 수.

        for (int i = 0; i < k; i++) {
            int com = Integer.parseInt(command.nextToken());

            int nx = x + dx[com-1];
            int ny = y + dy[com-1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            int[] arr = Arrays.copyOf(dice, dice.length);

            switch (com) {
                case 1:
                    // 2 -> 0
                    // 3 -> 5
                    // 5 -> 2
                    // 0 -> 3
                    arr[2] = dice[0];
                    arr[3] = dice[5];
                    arr[5] = dice[2];
                    arr[0] = dice[3];
                    break;
                case 2:
                    // 3 -> 0
                    // 2 -> 5
                    // 0 -> 2
                    // 5 -> 3
                    arr[3] = dice[0];
                    arr[2] = dice[5];
                    arr[0] = dice[2];
                    arr[5] = dice[3];
                    break;
                case 3:
                    // 1 -> 0
                    // 0 -> 4
                    // 5 -> 1
                    // 4 -> 5
                    arr[1] = dice[0];
                    arr[0] = dice[4];
                    arr[5] = dice[1];
                    arr[4] = dice[5];
                    break;
                case 4:
                    // 0 -> 1
                    // 4 -> 0
                    // 1 -> 5
                    // 5 -> 4
                    arr[0] = dice[1];
                    arr[4] = dice[0];
                    arr[1] = dice[5];
                    arr[5] = dice[4];
            }

            dice = arr;

            x = nx;
            y = ny;

            if (map[x][y] != 0) {
                dice[5] = map[x][y];
                map[x][y] = 0;
            } else {
                map[x][y] = dice[5];
            }

            System.out.println(dice[0]);
        }
    }
}

