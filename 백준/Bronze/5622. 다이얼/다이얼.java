import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int sum = 0;
        for (char c : input.toCharArray()) {

            switch (c) {

                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    sum++;
                case 'T':
                case 'U':
                case 'V':
                    sum++;
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    sum++;
                case 'M':
                case 'N':
                case 'O':
                    sum++;
                case 'J':
                case 'K':
                case 'L':
                    sum++;
                case 'G':
                case 'H':
                case 'I':
                    sum++;
                case 'D':
                case 'E':
                case 'F':
                    sum++;
                case 'A':
                case 'B':
                case 'C':
                    sum++;
                    sum += 2;
            }
        }

        System.out.println(sum);
    }
}