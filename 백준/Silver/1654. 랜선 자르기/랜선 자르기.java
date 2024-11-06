import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        long min = 0;
        long max = Long.MIN_VALUE;

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        max++;

        while (min < max) {

            long mid = (min + max) / 2;

            int count = 0;

            for (int i = 0; i < N; i++) {
                count += arr[i] / mid;
            }

            if (count < K) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.print(min - 1);
    }
}