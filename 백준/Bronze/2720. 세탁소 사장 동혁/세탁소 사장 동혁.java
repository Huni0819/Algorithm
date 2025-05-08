import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {

            int c = Integer.parseInt(br.readLine());

            sb.append(c / 25)
                    .append(" ");

            c %= 25;

            sb.append(c / 10)
                    .append(" ");

            c %= 10;

            sb.append(c / 5)
                    .append(" ");

            c %= 5;

            sb.append(c)
                    .append("\n");
        }

        System.out.println(sb);
    }
}