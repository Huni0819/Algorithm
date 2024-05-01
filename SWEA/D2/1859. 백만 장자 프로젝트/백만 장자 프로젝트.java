import java.util.Scanner;

public class Solution {


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            int N = scanner.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println("#" + tc + " " + solution(arr));
        }

        scanner.close();
    }

    public static long solution(int[] arr) {
        int count = 0;
        long sum = 0;
        long result = 0;

        int index = arr.length - 1;

        for (int i = arr.length - 1; i > 0; i--) {

            if (arr[i - 1] > arr[index]) {
                result += (arr[index] * count) - sum;
                sum = 0;
                count = 0;
                index = i - 1;
            } else {
                sum += arr[i - 1];
                count++;
            }
        }

        result += ((long) arr[index] * count) - sum;

        return result;
    }
}