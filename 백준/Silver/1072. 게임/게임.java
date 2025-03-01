import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        long X = Integer.parseInt(input[0]);
        long Y = Integer.parseInt(input[1]);

        int target = (int) ((Y * 100) / X);

        if (target >= 99) {

            System.out.println(-1);
            return;
        }

        int result = -1;
        int left = 0;
        int right = 1000000000;

        while (left <= right) {

            int mid = (left + right) / 2;

            int z = (int) (((Y + mid) * 100) / (X + mid));

            if (target >= z) {

                result = mid + 1;
                left = mid + 1;
            } else {

                right = mid - 1;
            }
        }

        System.out.println(result);

    }
}