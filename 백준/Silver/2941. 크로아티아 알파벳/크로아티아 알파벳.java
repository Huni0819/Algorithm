import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static String[] arr = {
            "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
    };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            while (line.contains(arr[i])) {

                count++;
                line = line.replaceFirst(arr[i], " ");
            }
        }

        System.out.println(count + line.replaceAll(" ", "").length());
    }
}