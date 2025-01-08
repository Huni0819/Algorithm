import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        solution(N, 1, 3, 2);
        System.out.println(count);
        System.out.print(sb);
    }

    static void solution(int N, int s, int e, int m) {

        if (N == 0) {
            return;
        }

        count++;
        solution(N - 1, s, m, e);

        sb.append(s)
                .append(" ")
                .append(e)
                .append("\n");

        solution(N - 1, m, e, s);
    }
}