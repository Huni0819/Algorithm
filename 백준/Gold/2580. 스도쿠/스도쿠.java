import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0);

    }

    public static void solution(int row, int col) {
        if (col == 9) {
            solution(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    builder.append(arr[i][j]).append(" ");
                }

                builder.append("\n");
            }

            System.out.println(builder);
            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    arr[row][col] = i;
                    solution(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }

        solution(row, col + 1);
    }

    private static boolean check(int row, int col, int val) {

        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == val || arr[i][col] == val) {
                return false;
            }
        }

        int smallRow = (row / 3) * 3;
        int smallCol = (col / 3) * 3;

        for (int i = smallRow; i < smallRow + 3; i++) {
            for (int j = smallCol; j < smallCol + 3; j++) {
                if (arr[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}
