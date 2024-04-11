import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = m; i <=n; i++) {
            if (check(i)) {
                writer.write(Integer.toString(i));
                writer.write("\n");
            }
        }

        writer.flush();
        writer.close();

        reader.close();
    }

    private static boolean check(int n) {
        if (n == 1) {
            return false;
        } else if (n == 2) {
            return true;
        }

        for (int i = 2;  i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}