import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                builder.append(" ");
            }

            for (int j = 0; j < (2 * n - 1) - (2 * i); j++) {
                builder.append("*");
            }

            builder.append("\n");
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - 1 - i; j++) {
                builder.append(" ");
            }

            for (int j = 0; j < 3 + 2 * i; j++) {
                builder.append("*");
            }

            builder.append("\n");
        }

        System.out.println(builder);

        reader.close();

    }
}