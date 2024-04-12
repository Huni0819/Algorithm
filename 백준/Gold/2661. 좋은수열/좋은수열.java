import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int start = 1;
    static int end = 3;
    static int n;


    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        solution("");

        reader.close();
    }

    private static void solution(String word) {

        if (word.length() == n) {
            System.out.println(word);
            System.exit(0);
        }

        for (int i = start; i <= end; i++) {
            if (checking(word + i)) {
                solution(word + i);
            }
        }
    }

    private static boolean checking(String word) {
        for (int i = 1; i <= word.length() / 2; i++) {
            String front = word.substring(word.length() - i * 2, word.length() - i);
            String back = word.substring(word.length() - i, word.length());

            if (front.equals(back)) {
                return false;
            }
        }

        return true;
    }
}