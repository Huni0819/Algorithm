import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            String[] input = br.readLine().split(" ");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            sb.append(solution(x, y))
                    .append("\n");
        }

        System.out.println(sb);
    }

    static int solution(int x, int y) {

        int distance = y - x;

        int max = (int) Math.sqrt(distance);

        if (max == Math.sqrt(distance)) {

            return 2 * max - 1;
        } else if (distance <= max * max + max) {

            return 2 * max;
        } else {

            return 2 * max + 1;
        }
    }
}