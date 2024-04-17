import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static int[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        visited = new int[n+1][m+1];

        String line;
        for (int i = 1; i <= n; i++) {
            line = reader.readLine();

            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(Character.toString(line.charAt(j-1)));
            }
        }

        solution(1, 1);

        reader.close();
    }

    private static void solution(int x, int y) {
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        xQueue.offer(x);
        yQueue.offer(y);
        visited[x][y] = 1;

        while (!xQueue.isEmpty() && !yQueue.isEmpty()) {
            int nowX = xQueue.poll();
            int nowY = yQueue.poll();

            if (nowX == n && nowY == m) {
                System.out.println(visited[nowX][nowY]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX;
                int nextY = nowY;

                if (i == 0) {
                    nextX -= 1;
                } else if (i == 1) {
                    nextY -= 1;
                } else if (i == 2) {
                    nextX += 1;
                } else {
                    nextY += 1;
                }

                if ((nextX < 1 || nextY < 1) || (nextX > n || nextY > m)) {
                    continue;
                }

                if (visited[nextX][nextY] != 0) {
                    continue;
                }

                if (arr[nextX][nextY] == 1) {
                    visited[nextX][nextY] = visited[nowX][nowY] + 1;
                    xQueue.offer(nextX);
                    yQueue.offer(nextY);
                }
            }
        }
    }


}