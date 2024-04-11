import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] visit;

    static int result = 0;

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        visit = new boolean[n][n];
        solution(0);

        System.out.println(result);

        reader.close();
    }

    private static void solution(int x) {
        if (x == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(x, i)) {
                visit[x][i] = true;
                solution(x+1);
                visit[x][i] = false;
            }
        }
    }

    private static boolean check(int x, int y) {
        for (int i = 0; i < n; i++) {
            if ((i <= y && visit[x][i]) || (i <= x && visit[i][y])) {
                return false;
            }

            if ((x+i < n && y+i < n && visit[x+i][y+i]) || (x+i < n && y-i >= 0 && visit[x+i][y-i])) {
                return false;
            }

            if ((x-i >= 0 && y-i >= 0 && visit[x-i][y-i]) || (x-i >= 0 && y+i <n && visit[x-i][y+i])) {
                return false;
            }
        }

        return true;
    }


}