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

        String line;
        while (!(line = reader.readLine()).equals("0")) {
            boolean check = true;

            for (int i = 0; i < line.length() / 2; i++) {
                if (line.charAt(i) != line.charAt(line.length() - i - 1)) {
                    System.out.println("no");
                    check = !check;
                    break;
                }
            }

            if (check) {
                System.out.println("yes");
            } 
        }

        reader.close();
    }
}