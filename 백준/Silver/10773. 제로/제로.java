import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();
        long sum = 0L;
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(reader.readLine());

            if (num == 0) {
                sum -= stack.pop();
            } else {
                sum += num;
                stack.push(num);
            }
        }

        System.out.println(sum);
    }
}