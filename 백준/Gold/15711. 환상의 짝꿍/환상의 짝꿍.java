import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isPrime;
    static List<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        isPrime = new boolean[(int) (Math.pow(10, 6) * 2 + 1)];
        Arrays.fill(isPrime, true);
        primeCalc();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            solution(a+b);

        }

        reader.close();
    }

    private static void primeCalc() {
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {

            for (int j = i * 2; j < isPrime.length; j+=i) {
                if (isPrime[j]) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }
    }

    private static void solution(long num) {
        if (num == 2) {
            System.out.println("NO");
        } else if (num % 2 == 0) {
            System.out.println("YES");
        } else {
            if (isPrime(num -2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private static boolean isPrime(long num) {
        if (num <= isPrime.length) {
            return isPrime[(int) num];
        } else {

            for (Integer prime : primeList) {
                if (num % prime == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}