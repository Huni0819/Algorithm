import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        int count = 0;
        int l = 0;
        int r = N - 1;

        while (l < r) {

            if (arr[l] + arr[r] < M) {

                l++;
            } else if (arr[l] + arr[r] > M) {

                r--;
            } else {

                count++;
                l++;
                r--;
            }
        }

        System.out.println(count);
    }
}