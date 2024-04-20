import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        System.out.println(solution(n));

        reader.close();
    }

    private static long solution(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        arr = new long[n+1];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 10_007;
        }

        return arr[n];
    }
}