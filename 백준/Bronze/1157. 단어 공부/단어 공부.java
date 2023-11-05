import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine().toUpperCase();

        int[] count = new int[100];

        for (char c : line.toCharArray()) {
            count[c]++;
        }

        int maxCount = 0;
        int max = 0;
        boolean check = false;
        for (char i = 'A'; i <= 'Z'; i++) {
            if (maxCount < count[i]) {
                maxCount = count[i];
                max = i;
                check = false;
            } else if (maxCount == count[i]) {
                check = true;
            }
        }

        if (check) {
            System.out.println("?");
        } else {
            System.out.println(Character.toChars(max));
        }


    }
}