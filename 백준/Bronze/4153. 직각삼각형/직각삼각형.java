import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int result = (int) (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2) - 2 * Math.pow(Math.max(a, Math.max(b, c)), 2));

            if (result == 0) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
        reader.close();
    }

}