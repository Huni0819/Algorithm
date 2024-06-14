import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static Number[] p;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        p = new Number[n];

        Number[] copy = new Number[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = new Number(i, Integer.parseInt(st.nextToken()));
            copy[i] = p[i];
        }

        Arrays.sort(copy, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {

                if (o1.price == o2.price) {
                    return o2.num - o1.num;
                }

                return o1.price - o2.price;
            }
        });

        m = Integer.parseInt(reader.readLine());

        if ((n > 1 && copy[0].num == 0 && copy[1].price > m) || n == 1) {
            System.out.println(0);
            System.exit(0);
        }

        List<Integer> list = new ArrayList<>();
        list.add(copy[0].num == 0 ? copy[1].num : copy[0].num);

        m = copy[0].num == 0 ? m - copy[1].price : m - copy[0].price;

        while (true) {
            if (copy[0].price > m) {
                break;
            }

            list.add(copy[0].num);
            m -= copy[0].price;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = p.length-1; j > list.get(i); j--) {
                if (m + p[list.get(i)].price - p[j].price >= 0) {
                    m = m + p[list.get(i)].price - p[j].price;

                    list.add(i, p[j].num);
                    list.remove(i+1);

                    break;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Integer i : list) {
            builder.append(i);
        }

        System.out.println(builder);
    }
}

class Number {
    int num;
    int price;

    public Number(int num, int price) {
        this.num = num;
        this.price = price;
    }
}