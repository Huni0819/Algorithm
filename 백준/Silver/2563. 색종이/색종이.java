import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[][] paper = new boolean[101][101];

        int count = 0;
        for (int i = 0; i < N; i++) {

            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);


            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {

                    if (!paper[j][k]) {

                        paper[j][k] = true;
                        count++;
                    }
                }
            }
        }
        
        System.out.println(count);
    }
}