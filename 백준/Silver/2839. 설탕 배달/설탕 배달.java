
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(solution(n));

        scanner.close();
    }

    private static int solution(int n) {
        int result = 0;

        while (n >= 3) {
            if (n % 5 == 0) {
                result += n / 5;
                n = n % 5;
                break;
            }

            n -= 3;
            result++;
        }

        if (n != 0) {
            return -1;
        }

        return result;
    }
}