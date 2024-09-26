import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(reader.readLine());
        int B = Integer.parseInt(reader.readLine());
        int C = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        builder.append(A+B-C).append("\n");
        builder.append(Integer.parseInt(Integer.toString(A) + Integer.toString(B)) - C);

        System.out.println(builder);
    }
}