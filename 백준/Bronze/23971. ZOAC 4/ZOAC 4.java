import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        solution.input();
        solution.solution();
    }
}

class Solution {
    // 앉음 & 못앉음 = 1, 앉지않음 = 0

    private int h;
    private int w;
    private int n;
    private int m;

    public void input() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        reader.close();
    }

    public void solution() {
        int width = (h - 1) / (n + 1) + 1;
        int height = (w - 1) / (m + 1) + 1;
        System.out.println(width * height);
    }
}