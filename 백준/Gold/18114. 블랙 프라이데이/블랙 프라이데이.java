import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] products;

    static int N;
    static int C;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        input = reader.readLine().split(" ");
        products = new int[N];

        for (int i = 0; i < N; i++) {
            products[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(products);

        for (int num : products) {
            if (num == C) {
                System.out.println(1);
                return;
            }
        }

        int i = 0;
        int j = N-1;
        while (i < j) {
            int sum = products[i] + products[j];

            if (sum == C) {
                System.out.println(1);
                return;
            } else if (sum > C) {
                j--;
            } else {
                int temp = C - sum;

                int low = i;
                int high = j;

                if (products[i] != temp && products[j] != temp && bs(low, high, temp)) {
                    System.out.println(1);
                    return;
                }

                i++;
            }
        }

        System.out.println(0);
    }

    private static boolean bs(int low, int high, int temp) {

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (products[mid] == temp) {
                return true;
            } else if (products[mid] > temp) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }


}