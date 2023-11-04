import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        String line = br.readLine();

        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += Integer.parseInt(Character.toString(line.charAt(i)));
        }

        System.out.println(sum);
    }
}