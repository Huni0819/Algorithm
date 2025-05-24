import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static String[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {

            n = Integer.parseInt(br.readLine());
            arr = new String[n];

            for (int i = 0; i < n; i++) {

                arr[i] = br.readLine();
            }

            sb.append(solution() ? "YES" : "NO")
                    .append("\n");
        }

        System.out.println(sb);
    }

    static boolean solution() {

        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {

            if (arr[i + 1].startsWith(arr[i])) {

                return false;
            }
        }

        return true;
    }
}