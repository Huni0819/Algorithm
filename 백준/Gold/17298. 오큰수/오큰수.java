import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] arr = new int[N];

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty()) {
                if(arr[stack.peek()] < arr[i]) {
                    arr[stack.peek()] = arr[i];
                    stack.pop();
                } else {
                    break;
                }
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 0; i < N; i++) {
            joiner.add(Integer.toString(arr[i]));
        }

        System.out.println(joiner);
    }
}