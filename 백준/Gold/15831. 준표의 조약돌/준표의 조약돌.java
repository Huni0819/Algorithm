import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int B;
    static int W;

    static int start;
    static int end;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        W = Integer.parseInt(input[2]);

        char[] arr = reader.readLine().toCharArray();

        start = 0;
        end = 0;

        int wCount = 0;
        int bCount = 0;

        int max = 0;
        while (end < N) {

            if (arr[end] == 'B') {
                if (bCount < B) {

                    bCount++;
                    end++;
                } else {
                    if (arr[start] == 'B') {
                        bCount--;
                    } else {
                        wCount--;
                    }
                    start++;
                }
            } else {
                wCount++;
                end++;
            }

            if (bCount <= B && wCount >= W) {
                max = Math.max(max, end - start);
            }
        }

        System.out.println(max);
    }


}