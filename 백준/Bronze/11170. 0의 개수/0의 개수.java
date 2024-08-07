import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(reader.readLine());

        for (int i = 0; i < tc; i++) {
            String[] input = reader.readLine().split(" ");

            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            int count = 0;
            for (int j = N; j <= M; j++) {
                for (char s : Integer.toString(j).toCharArray()) {
                    if (s == '0') {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}