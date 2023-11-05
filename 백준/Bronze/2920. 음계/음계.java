import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] words = br.readLine().split(" ");

        if (words[0].equals("1"))
            ascendingCheck(words);
        else if (words[0].equals("8"))
            descendingCheck(words);
        else {
            System.out.println("mixed");
        }
    }

    private static void descendingCheck(String[] words) {
        int number = Integer.parseInt(words[0]);

        for (String word : words) {
            if (number == Integer.parseInt(word))
                number--;
            else {
                System.out.println("mixed");
                return;
            }
        }

        System.out.println("descending");

    }

    private static void ascendingCheck(String[] words) {
        int number = Integer.parseInt(words[0]);

        for (String word : words) {
            if (number == Integer.parseInt(word))
                number++;
            else {
                System.out.println("mixed");
                return;
            }
        }

        System.out.println("ascending");
    }
}