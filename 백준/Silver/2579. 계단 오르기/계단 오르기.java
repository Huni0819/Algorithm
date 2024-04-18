import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] arr;
    static int n;
    static int[] calc;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        arr = new int[n+1];
        calc = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        calc[1] = arr[1];

        if (n >= 2) {
            calc[2] = arr[1] + arr[2];
        }

        System.out.println(solution(n));
        reader.close();
    }

    private static int solution(int num) {

        if (num <= 0) {
            return 0;
        }

        if (calc[num] == 0) {
            calc[num] = Math.max(solution(num - 2), solution(num - 3) + arr[num-1]) + arr[num];
        }

        return calc[num];
    }
}