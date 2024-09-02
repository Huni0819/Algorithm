import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);

        StringBuilder builder = new StringBuilder();

        input = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(input[i]) < X) {
                builder.append(input[i]).append(" ");
            }
        }

        System.out.println(builder);
    }
}