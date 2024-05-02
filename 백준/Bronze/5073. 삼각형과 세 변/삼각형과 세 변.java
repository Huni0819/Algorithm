import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        solution.solution();
    }
}

class Solution {

    public void solution() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while (true) {
            int max = Integer.MIN_VALUE;
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (a + b + c - 2 * Math.max(a, Math.max(b , c)) <= 0) {
                System.out.println("Invalid");
                continue;
            }

            if (a == b && b == c) {
                System.out.println("Equilateral");
            } else if ((a == b &&  b!= c) || (b == c && c != a) || (a == c && b != c)) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }

        reader.close();
    }
}