import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int count = 0;
    static int[][] arr;
    static List<Integer> result = new ArrayList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        String line;
        for (int i = 0; i < n; i++) {
            line = reader.readLine();

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    solution(i, j);
                    result.add(count);
                    count = 0;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(result.size()).append("\n");

        Collections.sort(result);

        for (int i = 0; i < result.size(); i++) {
            builder.append(result.get(i)).append("\n");
        }

        System.out.println(builder);

        reader.close();
    }

    private static void solution(int x, int y) {
        visited[x][y] = true;

        if (x != 0 && !visited[x-1][y] && arr[x-1][y] == 1) {
            solution(x-1, y);
        }

        if (y != 0 && !visited[x][y-1] && arr[x][y-1] == 1) {
            solution(x, y-1);
        }

        if (x < n-1 && !visited[x+1][y] && arr[x+1][y] == 1) {
            solution(x+1, y);
        }

        if (y < n-1 && !visited[x][y+1] && arr[x][y+1] == 1) {
            solution(x, y+1);
        }

        count++;
    }
}