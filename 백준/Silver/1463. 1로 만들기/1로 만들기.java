import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        System.out.println(solution(n, 0));
    }

    static int solution(int n, int count) {

        if (n < 2) {
            return count;
        }

        return Math.min(solution(n/2, count + 1 + (n % 2)), solution(n / 3, count + 1 + (n % 3)));
    }
}