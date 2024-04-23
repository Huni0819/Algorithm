import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static int max;
    static int min;
    static int sum = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];

            max = Math.max(max, arr[i]);
        }

        m = Integer.parseInt(reader.readLine());

        if (sum <= m) {
            System.out.println(max);
        } else {
            System.out.println(solution());
        }
        reader.close();
    }

    private static int solution() {

        while (min < max) {

            int mid = (min + max) / 2;

            int sum = 0;
            for (int i = 0; i < n; i++) {
                int num = arr[i] > mid ? mid : arr[i];
                sum += num;
            }

            if (sum > m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min - 1;
    }
}