import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(solution(n, m));

        scanner.close();
    }

    private static int solution(int n, int m) {
        String a = Integer.toString(n);
        String b = Integer.toString(m);

        String reverseA = "";
        String reverseB = "";


        for (int i = 2; i >= 0; i--) {
            reverseA += a.charAt(i);
            reverseB += b.charAt(i);
        }

        return Math.max(Integer.parseInt(reverseA), Integer.parseInt(reverseB));
    }
}