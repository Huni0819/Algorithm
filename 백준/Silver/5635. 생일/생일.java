import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Student[] arr = new Student[N];

        for (int i = 0; i < N; i++) {

            String[] input = br.readLine().split(" ");

            String name = input[0];
            int day = Integer.parseInt(input[1]);
            int month = Integer.parseInt(input[2]);
            int year = Integer.parseInt(input[3]);

            arr[i] = new Student(name, day, month, year);
        }

        Arrays.sort(arr, (o1, o2) -> o1.year != o2.year ? Integer.compare(o1.year, o2.year) : (o1.month != o2.month ? Integer.compare(o1.month, o2.month) : Integer.compare(o1.day, o2.day)));

        System.out.println(arr[N - 1].name);
        System.out.println(arr[0].name);
    }
}

class Student {

    String name;
    int day;
    int month;
    int year;

    public Student(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}