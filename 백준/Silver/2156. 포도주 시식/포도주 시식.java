import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] arr;
    static int[] calc;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        arr = new int[n+1];
        calc = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        System.out.println(solution(n));

        reader.close();
    }

    private static int solution(int n) {
        if (n == 1) {
            return arr[1];
        } else if (n == 2) {
            return arr[1] + arr[2];
        }
        calc[1] = arr[1];
        calc[2] = arr[1] + arr[2];

        for (int i = 3; i <= n ; i++) {
            calc[i] = Math.max(calc[i-2], calc[i-3] + arr[i-1]) + arr[i];

            calc[i] = Math.max(calc[i], calc[i-1]);
        }

        return calc[n];
    }
}