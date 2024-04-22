import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            count++;
            
            max = Math.max(arr[i] * count, max);
        }

        System.out.println(max);

        br.close();
    }
}