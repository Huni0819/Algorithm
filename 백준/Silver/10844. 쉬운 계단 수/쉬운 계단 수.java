import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static Long[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new Long[N + 1][10];

        Arrays.fill(arr[1], 1L);

        long result = 0;

        for (int i = 1; i <= 9; i++) {

            result += solution(N, i);
        }

        System.out.println(result % 1_000_000_000L);
    }

    static long solution(int digit, int val) {

        if (digit == 1) {

            return arr[digit][val];
        }

        if (arr[digit][val] == null) {

            if (val == 0) {

                arr[digit][val] = solution(digit - 1, 1);
            } else if (val == 9) {

                arr[digit][val] = solution(digit - 1, 8);
            } else {

                arr[digit][val] = solution(digit - 1, val - 1) + solution(digit - 1, val + 1);
            }
        }

        return arr[digit][val] % 1_000_000_000;
    }
}