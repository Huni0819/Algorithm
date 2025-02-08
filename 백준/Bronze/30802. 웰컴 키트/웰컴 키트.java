import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] input = br.readLine().split(" ");

        int T = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);

        int tSum = 0;
        for (int i = 0; i < arr.length; i++) {

            tSum += arr[i] / T;

            if (arr[i] % T != 0) {
                tSum++;
            }

        }

        StringBuilder sb = new StringBuilder();

        sb.append(tSum)
                .append("\n")
                .append(N / P)
                .append(" ")
                .append(N % P);

        System.out.println(sb);

    }
}