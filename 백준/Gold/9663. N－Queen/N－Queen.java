import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] array;
    static int n;
    static int count = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        array = new int[n];

        solution(0);

        System.out.println(count);

        reader.close();
    }

    private static void solution(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            array[depth] = i;

            if (check(depth)) {
                solution(depth+1);
            }
        }
    }

    private static boolean check(int depth) {
        for (int i = 0; i < depth; i++) {
            if (array[depth] == array[i]) {
                return false;
            } else if (Math.abs(depth-i) == Math.abs(array[depth] - array[i])) {
                return false;
            }
        }

        return true;
    }

}