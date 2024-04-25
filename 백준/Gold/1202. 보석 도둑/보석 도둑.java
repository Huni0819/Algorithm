import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

    static int[] arr;
    static Jewel[] jewelArray;

    public static void main(String[] args) throws Exception {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        jewelArray = new Jewel[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            jewelArray[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(jewelArray, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                if (o1.getWeight() == o2.getWeight()) {
                    return o2.getPrice() - o1.getPrice();
                }

                return o1.getWeight() - o2.getWeight();
            }
        });

        arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(arr);

        System.out.println(solution());

        reader.close();
    }

    private static long solution() {

        long sum = 0;
        int j = 0;

        for (int i =0; i < k; i++) {

            while (j < n && jewelArray[j].getWeight() <= arr[i]) {
                queue.offer(jewelArray[j++].getPrice());
            }

            if (!queue.isEmpty()) {
                sum += queue.poll();
            }
        }

        return sum;
    }
}

class Jewel {

    private int weight;
    private int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}