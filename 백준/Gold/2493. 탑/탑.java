import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        // N개의 탑에 대한 높이가 주어진다.
        // 각 탑의 index 번호는 1번부터 시작한다.
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Top> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {

            while (true) {
                if (stack.isEmpty()) {
                    builder.append("0 ");
                    stack.push(new Top(i+1, arr[i]));
                    break;
                }

                if (stack.peek().getHeight() > arr[i]) {
                    builder.append(stack.peek().getNum() + " ");
                    stack.push(new Top(i+1, arr[i]));
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        System.out.println(builder);
        reader.close();
    }
}

class Top {

    private int num;
    private int height;

    public Top(int num, int height) {
        this.num = num;
        this.height = height;
    }

    public int getNum() {
        return num;
    }

    public int getHeight() {
        return height;
    }
}