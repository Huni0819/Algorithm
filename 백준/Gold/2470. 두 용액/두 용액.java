import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    static int N;
    static int[] arr;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;

        int minLeft = 0;
        int minRight = 0;
        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == 0) {

                System.out.println(arr[left] + " " + arr[right]);
                return;
            }

            if (Math.abs(sum) < min) {

                min = Math.abs(sum);
                minLeft = left;
                minRight = right;
            }

            if (sum < 0) {

                left++;
            } else {
                right--;
            }
        }

        System.out.println(arr[minLeft] + " " + arr[minRight]);
    }
}