import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        BigInteger n = new BigInteger(input[0]);
        BigInteger m = new BigInteger(input[1]);

        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}