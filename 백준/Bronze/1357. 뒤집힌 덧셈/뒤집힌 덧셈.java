import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int X = Integer.parseInt(input[0]);
        int Y = Integer.parseInt(input[1]);

        System.out.println(solution(solution(X) + solution(Y)));
    }

    static int solution(int X) {

        String num = Integer.toString(X);

        int n = (int) Math.pow(10, num.length() - 1);
        int result = 0;
        for (int i = num.length() - 1; i >= 0; i--) {

            result += (num.charAt(i) - '0') * n;

            n /= 10;
        }

        return result;
    }
}