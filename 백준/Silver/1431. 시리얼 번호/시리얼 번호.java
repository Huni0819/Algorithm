import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if (o1.length() == o2.length()) {

                    int sum1 = 0;
                    int sum2 = 0;

                    for (int i = 0; i < o1.length(); i++) {

                        if (Character.isDigit(o1.charAt(i))) {
                            sum1 += o1.charAt(i) - '0';
                        }

                        if (Character.isDigit(o2.charAt(i))) {
                            sum2 += o2.charAt(i) - '0';
                        }
                    }

                    if (sum1 == sum2) {

                        for (int i = 0; i < o1.length(); i++) {

                            if (o1.charAt(i) == o2.charAt(i)) {
                                continue;
                            }

                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }

                    return sum1 - sum2;
                }

                return o1.length() - o2.length();
            }
        });

        for (String serial : arr) {

            System.out.println(serial);
        }
    }
}