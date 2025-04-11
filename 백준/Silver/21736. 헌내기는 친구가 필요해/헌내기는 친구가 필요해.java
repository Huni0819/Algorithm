import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    
    static int[][] d = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    static int N;
    static int M;
    
    static char[][] arr;
    static Node init;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                
                arr[i][j] = line.charAt(j);
                
                if (arr[i][j] == 'I') {
                    init = new Node(i, j);
                }
            }
        }

        int result = solution();
        System.out.println(result != 0 ? result : "TT");
    }
    
    static int solution() {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(init);
        
        boolean[][] visited = new boolean[N][M];
        visited[init.x][init.y] = true;
        
        int result = 0;
        while (!queue.isEmpty()) {
            
            Node now = queue.poll();
            
            for (int i = 0; i < d.length; i++) {
                
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || arr[nx][ny] == 'X') {
                    continue;
                }
                
                if (arr[nx][ny] == 'P') {
                    result++;
                }
                
                queue.offer(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
        
        return result;
    }
}

class Node {
    
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}