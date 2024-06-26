import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        int low = 1;
        int high = k;

        while (low < high) {
            int count = 0;

            int mid = low + (high - low) / 2;

            for (int i = 1; i < n + 1; i++) {
                count += Math.min(mid / i, n);
            }

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }
}