import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[21];

        for (int i = 1; i < 21; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = 0; j < (b-a+1)/2; j++) {
                int temp = arr[a+j];
                arr[a+j] = arr[b-j];
                arr[b-j] = temp;
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < arr.length; i++) {
            builder.append(arr[i]).append(" ");
        }

        System.out.println(builder);

        reader.close();
    }
}