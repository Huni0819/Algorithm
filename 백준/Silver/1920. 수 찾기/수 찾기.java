import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br;
    public static int[] array;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        array = new int[Integer.parseInt(br.readLine())];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < array.length && st.hasMoreTokens(); i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            binarySearch(Integer.parseInt(st.nextToken()), 0, array.length - 1);
        }
    }

    public static void binarySearch(int target, int low, int high) {
        int mid = (high + low) / 2;
        if (low > high) {
            System.out.println("0");
        } else if (target == array[mid]) {
            System.out.println("1");
        } else if (target > array[mid]) {
            binarySearch(target, mid + 1, high);
        } else {
            binarySearch(target, low, mid - 1);
        }
    }
}