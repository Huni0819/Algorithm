import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int w = Integer.parseInt(input[2]);
        int h = Integer.parseInt(input[3]);

        int min = Math.min(Math.abs(x - w), Math.min(Math.abs(0 - x),
                Math.min(Math.abs(y - h), Math.abs(0 - y))));

        System.out.println(min);
    }


}