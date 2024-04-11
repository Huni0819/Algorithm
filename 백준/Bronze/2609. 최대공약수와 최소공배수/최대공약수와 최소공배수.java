import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        solution(n, m);

        reader.close();
    }

    private static void solution(int n, int m) {
        int gcd = n >= m ? gcd(n, m) : gcd(m, n);
        int lcm = (n * m) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int gcd(int n, int m) {
        int r;

        while (m != 0) {
            r = n % m;
            n = m;
            m = r;
        }

        return n;
    }
}