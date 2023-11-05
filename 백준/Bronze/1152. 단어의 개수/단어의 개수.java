import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine().trim();

        String[] words = line.split(" ");

        int count = 0;

        for (String word : words) {
            if (!word.equals("")) {
                count++;
            }
        }

        System.out.println(count);
    }
}