import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int count = 0;

            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());

                if (a == 0) {
                    count++;
                }
            }

            System.out.println(check(count));
        }
    }

    private static String check(int count) {
        switch (count) {
            case 0:
                return "E";
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            default:
                return "D";
        }
    }
}