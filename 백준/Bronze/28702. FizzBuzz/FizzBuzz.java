import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        for (int i = 0; i < 3; i++) {

            String line = br.readLine();

            if (checkDigit(line)) {

                num = Integer.parseInt(line) + 3 - i;
            }
        }

        if (num % 3 == 0 && num % 5 == 0) {

            System.out.println("FizzBuzz");
        } else if (num % 3 == 0 && num % 5 != 0) {

            System.out.println("Fizz");
        } else if (num % 3 != 0 && num % 5 == 0) {

            System.out.println("Buzz");
        } else {

            System.out.println(num);
        }

    }

    static boolean checkDigit(String word) {

        for (char c : word.toCharArray()) {

            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}