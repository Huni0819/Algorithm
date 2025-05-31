import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    static long left;
    static long right;
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        for (int i = 0; i < N; i++) {

            sum += arr[i];
            left = Math.max(left, arr[i]);
        }
        right = sum;

        System.out.println(solution());
    }

    static long solution() {

        while (left <= right) {

            long sum = 0;
            long mid = (left + right) / 2;
            int count = 1;

            for (int i = 0; i < N; i++) {

                sum += arr[i];
                if (sum > mid) {

                    sum = arr[i];
                    count++;
                }
            }

            if (count <= M) {

                right = mid - 1;
            } else {

                left = mid + 1;
            }
        }

        return left;
    }
}