import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        int n = Integer.valueOf(reader.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.valueOf(reader.readLine());
        }

        Arrays.sort(array);

        for (int i : array) {
            writer.write(Integer.valueOf(i).toString());
            writer.newLine();
        }

        writer.flush();
    }
}