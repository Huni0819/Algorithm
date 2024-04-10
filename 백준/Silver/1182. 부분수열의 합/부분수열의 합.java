import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int result;
    static int count = 0;
    static int arr[];
    static boolean visited[];
    static int temp[];

    public static void main(String[] args) throws Exception{

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        result = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        temp = new int[n];
        visited = new boolean[n];

        for (int i = 1; i <= n; i++) {
            solution(0, 0, i);
        }

        System.out.println(count);
    }

    private static void solution(int start, int depth, int maxDepth) {
        if (depth == maxDepth) {
            int sum = 0;

            for (int i = 0; i < maxDepth; i++) {
                sum += temp[i];
            }

            count = sum == result ? count + 1 : count;
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = arr[i];
                solution(i, depth + 1, maxDepth);
                visited[i] = false;
            }
        }
    }
}