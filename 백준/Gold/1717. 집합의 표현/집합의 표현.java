import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            int com = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if (com == 0) {

                union(a, b);
            } else {

                sb.append(solution(a, b) ? "yes" : "no")
                        .append("\n");
            }
        }

        System.out.println(sb);
    }

    static int findParent(int num) {

        if (num == arr[num]) {
            return num;
        }

        return arr[num] = findParent(arr[num]);
    }

    static void union(int a, int b) {

        int aParent = findParent(a);
        int bParent = findParent(b);

        if (aParent == bParent) {
            return;
        }

        arr[Math.max(aParent, bParent)] = Math.min(aParent, bParent);
    }

    static boolean solution(int a, int b) {

        int aParent = findParent(a);
        int bParent = findParent(b);

        return aParent == bParent;
    }
}