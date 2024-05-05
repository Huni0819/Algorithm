import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder builder = new StringBuilder();
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            input(3, "@");
            input(1, " ");
            input(1, "@");
            builder.append("\n");
        }

        for (int i = 0; i < n * 3; i++) {
            input(1, "@");
            input(1, " ");
            input(1, "@");
            input(1, " ");
            input(1, "@");
            builder.append("\n");
        }

        for (int i = 0; i < n; i++) {
            input(1, "@");
            input(1, " ");
            input(3, "@");
            builder.append("\n");
        }

        System.out.println(builder);

        reader.close();
    }

    private static void input(int num, String word) {
        for (int i = 0; i < n; i++) {
            int count = 0;

            while (count < num) {
                builder.append(word);
                count++;
            }
        }
    }
}