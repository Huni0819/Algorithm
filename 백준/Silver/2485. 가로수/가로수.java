import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        reader.close();

        int result = solution();

        System.out.println(result);
    }

    private static int solution() {
        int gcd = 0;

        for (int i = 0; i < n-1; i++) {
            int distance = arr[i+1] - arr[i];

            gcd = gcd(distance, gcd);
        }

        return (arr[n-1] - arr[0])/gcd - (n - 1);
    }

    private static int gcd(int i, int j) {
        if (j > i) {
            int m = i;
            i = j;
            j = m;
        }

        int r;
        while (j != 0) {
            r = i%j;
            i = j;
            j = r;
        }

        return i;
    }
}