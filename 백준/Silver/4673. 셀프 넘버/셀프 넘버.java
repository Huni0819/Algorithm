public class Main {

    public static void main(String[] args) {

        boolean[] arr = new boolean[10_001];

        for (int i = 1; i <= 10_000; i++) {

            int num = solution(i);

            if (num <= 10000) {
                arr[num] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10_000; i++) {

            if (!arr[i]) {
                sb.append(i)
                        .append("\n");
            }
        }

        System.out.println(sb);
    }

    static int solution(int num) {

        int sum = num;

        while (num != 0) {

            sum += num % 10;

            num = num / 10;
        }

        return sum;
    }
}