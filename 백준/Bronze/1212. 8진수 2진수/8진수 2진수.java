import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        if (input.equals("0")) {
            System.out.println(input);
            System.exit(0);
        }

        for (int i = 0; i < input.length(); i++) {

            switch (input.charAt(i)) {

                case '0':
                    sb.append("000");
                    break;
                case '1':
                    sb.append("001");
                    break;
                case '2':
                    sb.append("010");
                    break;
                case '3':
                    sb.append("011");
                    break;
                case '4':
                    sb.append("100");
                    break;
                case '5':
                    sb.append("101");
                    break;
                case '6':
                    sb.append("110");
                    break;
                case '7':
                    sb.append("111");
                    break;
            }
        }

        while (sb.toString().startsWith("0")) {

            sb.replace(0, 1, "");
        }

        System.out.println(sb);

    }
}