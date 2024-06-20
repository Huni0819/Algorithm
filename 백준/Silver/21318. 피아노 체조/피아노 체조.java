import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n+1];
        int[] result = new int[n+1];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(reader.readLine());

        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i-1] > arr[i]) {
                sum++;
            }
            result[i] = sum;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            builder.append(result[y] - result[x]).append("\n");
        }

        System.out.println(builder);
    }
}