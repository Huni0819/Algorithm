import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int D = Integer.parseInt(input[2]);
        
        boolean[] time = new boolean[N * L + 5 * (N - 1)];

        for (int i = 0; i < N; i++) {

            int songTime = (L + 5) * i;
            
            for (int j = songTime; j < songTime + L; j++) {
                time[j] = true;
            }
        }
        
        int result = 0;
        
        while (result < time.length) {
            
            if (!time[result]) {
                break;
            }
            
            result += D;
        }

        System.out.println(result);

    }
}