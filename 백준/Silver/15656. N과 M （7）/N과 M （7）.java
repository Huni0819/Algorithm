import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int m;
    static int[] arr;

    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solution(0, "");

        System.out.println(builder);
    }

    private static void solution(int depth, String str) {
        if (depth == m) {
            builder.append(str).append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            solution(depth+1, str + Integer.toString(arr[i]) + " ");
        }
    }
}