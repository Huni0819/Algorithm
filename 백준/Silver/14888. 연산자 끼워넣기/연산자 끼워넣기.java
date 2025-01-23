import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    static int N;
    static int[] arr;
    static int[] op;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        op = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void solution(int idx, int result) {

        if (idx == N) {

            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {

            if (op[i] > 0) {

                op[i]--;

                switch (i) {

                    case 0:
                        solution(idx + 1, result + arr[idx]);
                        break;
                    case 1:
                        solution(idx + 1, result - arr[idx]);
                        break;
                    case 2:
                        solution(idx + 1, result * arr[idx]);
                        break;
                    case 3:
                        solution(idx + 1, result / arr[idx]);
                        break;
                }

                op[i]++;
            }
        }
    }
}