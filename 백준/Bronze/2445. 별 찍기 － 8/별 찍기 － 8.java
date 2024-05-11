import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {
                builder.append("*");
            }

            for (int j = 0; j < n-i; j++) {
                builder.append(" ");
            }

            for (int j = 0; j < n-i; j++) {
                builder.append(" ");
            }

            for (int j = 0; j < i; j++) {
                builder.append("*");
            }

            builder.append("\n");
        }

        for (int i = 0; i < 2*n; i++) {
            builder.append("*");
        }

        builder.append("\n");

        for (int i = n-1; i >= 0; i--) {

            for (int j = 0; j < i; j++) {
                builder.append("*");
            }

            for (int j = 0; j < n-i; j++) {
                builder.append(" ");
            }

            for (int j = 0; j < n-i; j++) {
                builder.append(" ");
            }

            for (int j = 0; j < i; j++) {
                builder.append("*");
            }

            builder.append("\n");
        }

        System.out.println(builder);

        reader.close();

    }
}