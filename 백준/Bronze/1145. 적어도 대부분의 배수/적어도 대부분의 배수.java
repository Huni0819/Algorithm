import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {

            arr[i] = Integer.parseInt(input[i]);
        }

        int result = 0;
        int count = 0;
        while (true) {

            result++;

            for (int i = 0; i < 5; i++) {

                if (result >= arr[i] && result % arr[i] == 0) {
                    count++;
                }
            }

            if (count >= 3) {
                break;
            }

            count = 0;
        }

        System.out.println(result);
    }
}