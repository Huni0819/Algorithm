import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        int[] arr = new int[10];

        for (char s : line.toCharArray()) {
            arr[s - '0']++;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                continue;
            }

            max = Math.max(max, arr[i]);
        }

        max = Math.max(max, (arr[6] + arr[9] + 1) / 2);

        System.out.println(max);

        reader.close();
    }
}