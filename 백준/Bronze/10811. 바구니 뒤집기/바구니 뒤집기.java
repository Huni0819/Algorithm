import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(reader.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            while (i-1 < j-1) {
                int temp = arr[i-1];
                arr[i++-1] = arr[j-1];
                arr[j---1] = temp;
            }
        }

        StringBuilder builder = new StringBuilder();
        Arrays.stream(arr).forEach(num -> builder.append(num).append(" "));

        System.out.println(builder);
        reader.close();
    }


}