import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static int max;
    static int min;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        System.out.println(solution());

        reader.close();
    }

    private static int solution() {
        Arrays.sort(arr);

        max = arr[n-1] - arr[0] + 1;
        min = 1;

        while (min < max) {

            int mid = (min + max) / 2;

            int count = 1;
            int prev = arr[0];

            for (int i = 1; i < n; i++) {
                if (Math.abs(arr[i] - prev) >= mid) {
                    prev = arr[i];
                    count++;
                }
            }

            if (count < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min - 1;

    }
}