import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[9][9];
        int max = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] > max) {
                    max = arr[i][j];
                    x = i+1;
                    y = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.println(x + " " + y);

        reader.close();
    }
}