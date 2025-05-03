import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double total = 0D;
        double me = 0D;
        for (int i = 0; i < 20; i++) {

            String[] input = br.readLine().split(" ");

            String name = input[0];

            if (input[2].equals("P")) {
                continue;
            }

            total += Double.parseDouble(input[1]);
            me += Double.parseDouble(input[1]) * solution(input[2]);
        }

        System.out.printf("%6f", me / total);
    }

    static double solution(String word) {

        if (word.equals("A+")) {

            return 4.5D;
        } else if (word.equals("A0")) {

            return 4.0D;
        } else if (word.equals("B+")) {

            return 3.5D;
        } else if (word.equals("B0")) {

            return 3.0D;
        } else if (word.equals("C+")) {

            return 2.5D;
        } else if (word.equals("C0")) {

            return 2.0D;
        } else if (word.equals("D+")) {

            return 1.5D;
        } else if (word.equals("D0")) {

            return 1.0D;
        } else {

            return 0D;
        }
    }
}