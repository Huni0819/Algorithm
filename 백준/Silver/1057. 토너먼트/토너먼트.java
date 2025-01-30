import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int zimin = Integer.parseInt(input[1]);
        int hansu = Integer.parseInt(input[2]);

        int count = 0;
        while (zimin != hansu) {

            zimin = zimin / 2 + zimin % 2;
            hansu = hansu / 2 + hansu % 2;

            count++;
        }

        System.out.println(count);

    }
}