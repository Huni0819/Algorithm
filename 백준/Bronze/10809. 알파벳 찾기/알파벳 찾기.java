import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] count = new int[150];

        for (int i = 0; i < count.length; i++) {
            count[i] = -1;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (count[c] == -1) {
                count[c] = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 'a'; i <= 'z'; i++) {
            sb.append(count[i]).append(" ");
        }

        System.out.println(sb);
    }
}