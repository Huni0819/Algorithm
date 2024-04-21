import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();

        System.out.println(calc[n]);

        reader.close();
    }

    private static void solution() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                calc[i] = Math.max(calc[i], calc[i-j] + arr[j]);
            }
        }
    }
}