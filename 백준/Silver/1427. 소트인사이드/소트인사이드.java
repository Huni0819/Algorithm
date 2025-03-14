import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] N = Stream.of(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(N);

        StringBuilder sb = new StringBuilder();

        for (int i = N.length - 1; i >= 0; i--) {
            sb.append(N[i]);
        }

        System.out.println(sb);
    }

}