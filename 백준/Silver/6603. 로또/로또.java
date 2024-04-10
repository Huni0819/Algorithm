import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] result;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!(line = reader.readLine()).equals("0")) {
            builder.delete(0, builder.length());

            StringTokenizer st = new StringTokenizer(line);

            k = Integer.parseInt(st.nextToken());

            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            result = new int[6];
            visited = new boolean[k];
            solution(0, 0);

            System.out.println(builder);
        }
    }

    private static void solution(int start, int depth) {
        if (depth == 6) {
            Arrays.stream(result).forEach(num -> builder.append(num)
                    .append(" "));

            builder.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                solution(i, depth + 1);
                visited[i] = false;
            }
        }
    }
}