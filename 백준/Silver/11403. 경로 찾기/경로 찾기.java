import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int[][] arr;

    static int[][] result;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {

            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {

                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < N; i++) {

            solution(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                sb.append(result[i][j])
                        .append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void solution(int x) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        boolean[] visited = new boolean[N];

        while(!queue.isEmpty()) {

            int now = queue.poll();

            for (int i = 0; i < N; i++) {

                if (visited[i]) {
                    continue;
                }

                if (arr[now][i] == 1) {

                    queue.offer(i);
                    visited[i] = true;
                    result[x][i] = 1;
                }
            }
        }
    }
}