import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer> breakdown = new ArrayList<>();

        if (M != 0) {
            String[] input = br.readLine().split(" ");

            for (int i = 0; i < M; i++) {

                int num = Integer.parseInt(input[i]);

                breakdown.add(num);
            }
        }

        int min = Math.abs(100 - N);
        int count = 0;
        for (int i = 0; i < 1_000_000; i++) {

            String num = Integer.toString(i);
            boolean flag = true;

            for (int j = 0; j < num.length(); j++) {

                if (!breakdown.isEmpty() && breakdown.contains(num.charAt(j) - '0')) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                continue;
            }

            count = num.length() + Math.abs(i - N);
            min = Math.min(min, count);
        }

        System.out.println(min);
    }
}