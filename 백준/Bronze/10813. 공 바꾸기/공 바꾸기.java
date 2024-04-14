import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main (String[] args) throws Exception {

        BufferedReader reader = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            swap(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            builder.append(arr[i]).append(" ");
        }

        System.out.println(builder);


        reader.close();
    }

    private static void swap (int i, int j) {
        int temp = arr[i-1];
        arr[i-1] = arr[j-1];
        arr[j-1] = temp;
    }
}