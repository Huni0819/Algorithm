import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int n;
    static int[] arr;
    static long max;
    static long min;


    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(reader.readLine());

            max = Math.max(arr[i], max);
        }

        max++;

        System.out.println(solution());
        reader.close();
    }

    private static long solution() {

        if (max == 1) {
            return 1;
        }

        while (min < max) {
            long mid = (min + max) / 2;
            int count = 0;

            for (int i = 0; i < k; i++) {
                count += (arr[i] / mid);
            }

            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

        return min-1;
    }
}