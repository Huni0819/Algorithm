import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int[] arr;
    static int[] calc;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        calc = new int[k+1];
        calc[0] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());

            for (int j = arr[i]; j <= k; j++) {
                calc[j] += calc[j - arr[i]];
            }
        }

        System.out.println(calc[k]);


        reader.close();
    }
}