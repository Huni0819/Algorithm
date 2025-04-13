import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Problem[] arr = new Problem[8];
        int sum = 0;
        for (int i = 1; i <= 8; i++) {

            arr[i - 1] = new Problem(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr, (o1, o2) -> o2.score - o1.score);

        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {

            sum += arr[i].score;
            nums[i] = arr[i].num;
        }

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        sb.append(sum)
                .append("\n");

        for (int i = 0; i < 5; i++) {

            sb.append(nums[i])
                    .append(" ");
        }

        System.out.println(sb);
    }
}

class Problem {

    int num;
    int score;

    public Problem(int num, int score) {
        this.num = num;
        this.score = score;
    }
}