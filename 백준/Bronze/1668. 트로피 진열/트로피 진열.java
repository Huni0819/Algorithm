import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(br.readLine());
        }

        int left = arr[0];
        int right = arr[N-1];

        int lCount = 1;
        for (int i = 1; i < N; i++) {

            if (arr[i] > left) {
                lCount++;
                left = arr[i];
            }
        }

        int rCount = 1;
        for (int i = N-2; i >= 0; i--) {

            if (arr[i] > right) {
                rCount++;
                right = arr[i];
            }
        }

        System.out.println(lCount);
        System.out.println(rCount);
    }
}