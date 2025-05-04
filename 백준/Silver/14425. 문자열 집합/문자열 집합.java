import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {

            set.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {

            String word = br.readLine();

            if (set.contains(word)) {

                count++;
            }
        }

        System.out.println(count);
    }
}