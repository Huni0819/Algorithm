import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < N; i++) {

            if (solution(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean solution(int idx) {

        int left = 0;
        int right = N - 1;

        while (left < right) {

            if (left == idx) {
                left++;
                continue;
            }

            if (right == idx) {
                right--;
                continue;
            }

            int sum = arr[left] + arr[right];

            if (sum == arr[idx]) {
                return true;
            }

            if (sum > arr[idx]) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }
}