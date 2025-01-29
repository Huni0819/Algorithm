import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] pack = new int[M];
        int[] unit = new int[M];

        for (int i = 0; i < M; i++) {

            input = br.readLine().split(" ");

            pack[i] = Integer.parseInt(input[0]);
            unit[i] = Integer.parseInt(input[1]);
        }

        Arrays.sort(pack);
        Arrays.sort(unit);

        int min = Math.min(((N/6) + 1) * pack[0],
                Math.min(N*unit[0], ((N/6) * pack[0] + (N % 6) * unit[0])));

        System.out.println(min);
    }
}