import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(br.readLine());

            Count c = new Count();

            fibonacci(n, c);

            System.out.println(c.getZeroCount() + " " + c.getOneCount());
        }
    }

    private static void fibonacci(int n, Count count) {
        for (int i = 0; i < n; i++) {
            count.setZeroCount(count.getOneCount());
            count.setOneCount(count.getZeroPlusOne());
            count.setZeroPlusOne(count.getZeroCount() + count.getOneCount());
        }
    }

    private static class Count {
        int zeroCount;
        int oneCount;
        int zeroPlusOne;

        public Count() {
            zeroCount = 1;
            oneCount = 0;
            zeroPlusOne = 1;
        }

        public int getZeroCount() {
            return zeroCount;
        }

        public void setZeroCount(int zeroCount) {
            this.zeroCount = zeroCount;
        }

        public int getOneCount() {
            return oneCount;
        }

        public void setOneCount(int oneCount) {
            this.oneCount = oneCount;
        }

        public int getZeroPlusOne() {
            return zeroPlusOne;
        }

        public void setZeroPlusOne(int zeroPlusOne) {
            this.zeroPlusOne = zeroPlusOne;
        }
    }
}