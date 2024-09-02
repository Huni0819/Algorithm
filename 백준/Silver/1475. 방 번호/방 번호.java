import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String N = reader.readLine();

        int[] arr = new int[10];

        for (int i = 0; i < N.length(); i++) {

            arr[N.charAt(i) - '0']++;
        }

        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 6 && i != 9) {
                max = Math.max(max, arr[i]);
            }
        }

        int six = (arr[6] + arr[9]) / 2;

        if ((arr[6] + arr[9]) % 2 != 0) {
            six++;
        }

        max = Math.max(max, six);

        System.out.println(max);
    }
}