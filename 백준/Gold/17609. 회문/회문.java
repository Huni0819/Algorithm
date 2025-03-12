import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {

            String word = br.readLine();

            sb.append(solution(0, word.length() - 1, 0, word))
                    .append("\n");
        }

        System.out.println(sb);
    }

    static int solution(int s, int e, int check, String word) {

        if (check >= 2) {
            return 2;
        }

        while (s < e) {

            if (word.charAt(s) == word.charAt(e)) {

                s++;
                e--;
            } else {

                return Math.min(solution(s + 1, e, check + 1, word), solution(s, e - 1, check + 1, word));
            }
        }

        return check;
    }
}