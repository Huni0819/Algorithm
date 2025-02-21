import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            String input = br.readLine();

            if (input.equals("#")) {
                break;
            }

            int result = 0;

            for (int i = 0; i < input.length(); i++) {

                int num;

                switch (input.charAt(i)) {

                    case '-':
                        num = 0;
                        break;
                    case '\\':
                        num = 1;
                        break;
                    case '(':
                        num = 2;
                        break;
                    case '@':
                        num = 3;
                        break;
                    case '?':
                        num = 4;
                        break;
                    case '>':
                        num = 5;
                        break;
                    case '&':
                        num = 6;
                        break;
                    case '%':
                        num = 7;
                        break;
                    default:
                        num = -1;
                        break;
                }

                result += (int) Math.pow(8, input.length() - i - 1) * num;
            }

            sb.append(result)
                    .append("\n");
        }

        System.out.println(sb);

    }
}