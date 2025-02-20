import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        String L = input[1];

        int count = 0;

        while (N > 0) {

            count++;

            if (!Integer.toString(count).contains(L)) {
                N--;
            }
        }

        System.out.println(count);
    }
}