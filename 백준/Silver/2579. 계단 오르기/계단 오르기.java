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

        for (int i = 3; i <= num; i++) {
            calc[i] = Math.max(calc[i-2], calc[i-3] + arr[i-1]) + arr[i];
        }

        return calc[num];
    }
}