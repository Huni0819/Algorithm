import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int arr[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int result = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    result++;
                }
            }

            builder.append(result).append(" ");
        }

        System.out.println(builder);

        reader.close();
    }
}