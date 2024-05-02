import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        solution.solution();
    }
}

class Solution {
    // 1 6 12 18...

    public void solution() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int count = 1;
        int re = 1;
        while (true) {
            if (re >= n) {
                break;
            }

            re += count * 6;
            count++;


        }

        System.out.println(count);

        reader.close();
    }
}