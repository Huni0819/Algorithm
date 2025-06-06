import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        if (N >= 1) {

            arr[1] = 1;
        }

        for (int i = 2; i <= N; i++) {

            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.println(arr[N]);
    }
}