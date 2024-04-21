import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arrA = new int[n][m];
        int[][] arrB = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < m; j++) {
                arrA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < m; j++) {
                arrB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                builder.append(arrA[i][j] + arrB[i][j]).append(" ");
            }

            builder.append("\n");
        }

        System.out.println(builder);

        reader.close();
    }
}