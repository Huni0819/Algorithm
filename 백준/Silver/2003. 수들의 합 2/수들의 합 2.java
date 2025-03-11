import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] A = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int s = 0;
        int e = 0;

        int sum = 0;
        int count = 0;
        while (true) {

            if (sum >= M) {
                sum -= A[s++];
            } else if (e == N) {
                break;
            }else {
                sum += A[e++];
            }

            if (sum == M) {
                count++;
            }
        }

        System.out.println(count);
    }
}