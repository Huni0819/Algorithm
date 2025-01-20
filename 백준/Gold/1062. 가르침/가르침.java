import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int K;

    static int max = 0;
    static String[] arr;
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        arr = new String[N];

        for (int i = 0; i < N; i++) {

            arr[i] = br.readLine()
                    .replaceAll("[antic]", "");
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        solution(0, 0);
        System.out.println(max);
    }

    static void solution(int idx, int dep) {

        if (dep == K - 5) {

            int count = 0;

            for (int i = 0; i < N; i++) {

                boolean flag = true;

                for (int j = 0; j < arr[i].length(); j++) {

                    if (!visited[arr[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    count++;
                }
            }

            max = Math.max(max, count);
            return;
        }

        for (int i = idx; i < 26; i++) {

            if (!visited[i]) {

                visited[i] = true;
                solution(i, dep + 1);
                visited[i] = false;
            }
        }

    }
}