import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static int M;
    static int result = 0;

    static List<Integer>[] lists;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        lists = new List[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {

            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            lists[a].add(b);
            lists[b].add(a);
        }

        for (int i = 0; i < N; i++) {

            if (result == 0) {
                solution(i, 1);
            }
        }

        System.out.println(result);
    }

    static void solution(int idx, int dep) {

        if (dep == 5) {

            result = 1;
            return;
        }

        visited[idx] = true;

        for (int num : lists[idx]) {

            if (!visited[num]) {

                solution(num, dep + 1);
            }
        }

        visited[idx] = false;
    }
}