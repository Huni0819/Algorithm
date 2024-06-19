import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            arr[i] = new int[Integer.parseInt(st.nextToken())];

            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] light = new boolean[m];
        for (int i = 0; i < n; i++) {
            boolean check = false;
            Arrays.fill(light, false);
            for (int j = 0; j < n; j++) {
                if (i != j) {

                    for (int k = 0; k < arr[j].length; k++) {
                        light[arr[j][k] - 1] = true;
                    }

                }
            }

            if (check(light)) {
                System.out.println(1);
                System.exit(0);
            }
        }

        System.out.println(0);
    }

    private static boolean check(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                return false;
            }
        }

        return true;
    }
}