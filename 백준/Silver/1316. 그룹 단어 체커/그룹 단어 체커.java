import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {

            String word = br.readLine();
            boolean[] check = new boolean['z' - 'a' + 1];

            boolean flag = true;
            for (int j = 0; j < word.length(); j++) {

                if (check[word.charAt(j) - 'a']) {
                    flag = false;
                    break;
                }

                check[word.charAt(j) - 'a'] = true;
                int idx = j;
                while (idx < word.length() && word.charAt(j) == word.charAt(idx)) {

                    idx++;
                }

                j = idx - 1;
            }

            if (flag) {
                count++;
            }
        }

        System.out.println(count);
    }
}