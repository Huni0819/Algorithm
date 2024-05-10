import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] arr = new int[N];
        int[] sum = new int[N * N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum[count++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(sum, 0, count -1);

        for (int i = N-1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (Arrays.binarySearch(sum, 0, count-1, arr[i] - arr[j]) < 0) {
                    continue;
                }

                System.out.println(arr[i]);
                return;
            }
        }

        reader.close();
    }
}