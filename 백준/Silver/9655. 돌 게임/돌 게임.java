import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        solution();
        reader.close();
    }

    private static void solution() {

        if (n % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

    }
}