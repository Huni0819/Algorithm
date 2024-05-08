import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        /**
         * arr[1] = arr[2] = arr[3] = 1
         *
         * arr[4] 부터
         * arr[n] = arr[n-2] + arr[n-3]
         */

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());

            if (n <= 3) {
                System.out.println(1);
                continue;
            }

            long arr[] = new long[n+1];

            arr[1] = arr[2] = arr[3] = 1;

            for (int j = 4; j <= n; j++) {
                arr[j] = arr[j-2] + arr[j-3];
            }

            System.out.println(arr[n]);
        }

        reader.close();
    }
}