import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        for (int i = 0; i < 8; i++) {

            String line = br.readLine();
            for (int j = 0; j < 8; j++) {

                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {

                    if (line.charAt(j) == 'F') {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

    }
}