import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static boolean[] isPrime = new boolean[1_000_001];

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(isPrime, true);

        calcPrime();

        String line;
        while (!(line = reader.readLine()).equals("0")) {

            solution(Integer.parseInt(line));
        }

        reader.close();
    }

    private static void calcPrime() {
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(1_000_000); i++) {
            for (int j = i * 2; j < 1_000_001; j += i) {
                isPrime[j] = false;
            }
        }
    }

    private static void solution(int num) {
        StringBuilder builder = new StringBuilder();

        for (int i = 2; i <= num / 2; i++) {
            if (isPrime[i] && isPrime[num - i]) {
                builder.append(num)
                        .append(" = ")
                        .append(i)
                        .append(" + ")
                        .append(num - i);
                System.out.println(builder);
                return;
            }
        }

        System.out.println("Goldbach's conjecture is wrong.");
    }

}