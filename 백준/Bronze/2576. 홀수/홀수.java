import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(reader.readLine());

            if (num % 2 != 0) {
                sum += num;
                min = Math.min(min, num);
            }
        }

        if (sum != 0) {
            System.out.println(sum);
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
        reader.close();
    }
}