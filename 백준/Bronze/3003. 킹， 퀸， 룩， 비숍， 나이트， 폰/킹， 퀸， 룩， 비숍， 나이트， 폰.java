import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    static int[] chess = {
            1, 1, 2, 2, 2, 8
    };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {

            sb.append(chess[i] - arr[i])
                    .append(" ");
        }

        System.out.println(sb);
    }
}