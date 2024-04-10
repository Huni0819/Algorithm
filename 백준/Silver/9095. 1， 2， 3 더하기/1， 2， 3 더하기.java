import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[] array = new int[11];

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(reader.readLine());

            int result = bottomUp(num);

            writer.write(Integer.toString(result));
            writer.write("\n");
        }

        writer.flush();
        reader.close();
        writer.close();
    }

    private static int topDown(int num) {
        array[0] = 1;
        array[1] = 2;
        array[2] = 4;

        if (num <= 3 || array[num-1] != 0) {
            return array[num-1];
        }

        return array[num-1] = topDown(num-1) + topDown(num-2) + topDown(num-3);
    }

    private static int bottomUp(int num) {
        array[0] = 1;
        array[1] = 2;
        array[2] = 4;

        if (num > 3) {
            for (int i = 3; i < num; i++) {
                array[i] = array[i - 1] + array[i - 2] + array[i - 3];
            }
        }

        return array[num-1];
    }
}