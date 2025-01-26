import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        char[] arr = new char[26];

        for (int i = 0; i < N; i++) {

            String line = br.readLine();

            arr[line.charAt(0) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {

            if (arr[i] >= 5) {

                sb.append(Character.toChars(i + 'a'));
            }
        }

        System.out.println(sb.toString().isEmpty() ? "PREDAJA" : sb);

    }
}