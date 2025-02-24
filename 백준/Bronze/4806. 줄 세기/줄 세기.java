import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        int count = 0;
        while ((line = br.readLine()) != null) {

            count++;
        }

        System.out.println(count);
    }
}