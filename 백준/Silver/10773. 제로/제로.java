
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(solution(n, scanner));

        scanner.close();
    }

    private static int solution(int n, Scanner scanner) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        return stack.stream().reduce(0, (x, y) -> x + y);
    }
}