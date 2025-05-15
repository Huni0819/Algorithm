import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int m;
    static int[][] arr;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];

        // 초기화
        for (int i = 1; i <= n; i++) {

            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }

        // 간선 정보 입력
        String[] input;
        for (int i = 0; i < m; i++) {

            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);


            arr[a][b] = Math.min(arr[a][b], c);
        }

        // 플로이드 워셜 알고리즘
        for (int k = 1; k <= n; k++) { // 중간 노드
            for (int i = 1; i <= n; i++) { // 시작 노드
                for (int j = 1; j <= n; j++) { // 도착 노드

                    if (arr[i][k] != INF && arr[k][j] != INF) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                sb.append(arr[i][j] == Integer.MAX_VALUE ? 0 : arr[i][j])
                        .append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}