import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    static final String YES = "YES";
    static final String NO = "NO";

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < t; i++) {
            boolean flag = true;
            int count = 0;
            String line = reader.readLine();

            for (char c : line.toCharArray()) {
                count = c == '(' ? count + 1 : count - 1;

                if (count < 0) {
                    flag = false;
                    break;
                }
            }

            builder.append(flag && count == 0 ? YES : NO).append("\n");
        }

        writer.write(builder.toString());
        writer.flush();

        writer.close();
        reader.close();
    }
}