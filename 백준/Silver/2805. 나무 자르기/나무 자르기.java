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

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max, arr[i]);
        }

        Arrays.sort(arr);

        System.out.println(solution());

        reader.close();
    }

    private static int solution() {
        while (min < max) {
            int mid = (min + max) / 2;

            long sum = 0;

            for (int i = 0; i < n; i++) {

                if (arr[i] - mid > 0) {
                    sum += arr[i] - mid;
                }
            }

            if (sum < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min - 1;
    }
}