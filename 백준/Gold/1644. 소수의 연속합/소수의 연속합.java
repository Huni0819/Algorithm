import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int count = 0;
    static int n;
    static boolean[] isPrime;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, true);
        calc();

        solution();
        System.out.println(count);
        reader.close();
    }

    private static void calc() {
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * 2; j < n + 1; j += i) {
                isPrime[j] = false;
            }
        }
    }

    private static void solution() {
        for (int k = 2; k < n + 1; k++) {
            if (isPrime[k]) {
                int sum = 0;
                for (int i = k; i < n + 1; i++) {
                    if (isPrime[i]) {
                        sum += i;

                        if (n == sum) {
                            count++;
                        }

                        if (n <= sum) {
                            break;
                        }
                    }
                }
            }
        }
    }

}