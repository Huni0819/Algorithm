import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger[] arr = new BigInteger[N + 1];
        arr[0] = BigInteger.ZERO;

        if (N >= 1) {

            arr[1] = BigInteger.ONE;
        }

        for (int i = 2; i <= N; i++) {

            arr[i] = arr[i-1].add(arr[i-2]);
        }

        System.out.println(arr[N]);
    }
}