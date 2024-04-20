import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] calc = new int[n];
        calc[0] = arr[0];

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            calc[i] = Math.max(arr[i], calc[i-1] + arr[i]);

            max = Math.max(max, calc[i]);
        }

        System.out.println(max);
    }
}