import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    static int N;
    static int S;

    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        arr = new int[N + 1];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(input[i]);
        }

        System.out.println(solution());
    }

    static int solution() {

        int s = 0;
        int e = 0;

        int sum = 0;
        int length = Integer.MAX_VALUE;
        while (s <= e && e <= N) {

            if (sum < S) {
                sum += arr[e++];
            } else if (sum >= S) {
                length = Math.min(length, e - s);
                sum -= arr[s++];
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
}