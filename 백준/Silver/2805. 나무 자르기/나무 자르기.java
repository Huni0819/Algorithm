import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        long max = Long.MAX_VALUE;
        long min = 0;

        while (min < max) {

            long mid = (max + min) / 2;

            long count = 0;
            for (int i = 0; i < N; i++) {
                count += arr[i] - mid > 0 ? arr[i] - mid : 0;
            }

            if (count < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.print(min - 1);
    }
}