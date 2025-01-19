import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String one = br.readLine();
        String two = br.readLine();
        String three = br.readLine();

        System.out.println(solution(one, two, three));
    }

    static long solution(String one, String two, String three) {

        long result = calc(true, one);
        result = result * 10 + calc(true, two);
        result = result * calc(false, three);

        return result;
    }

    static int calc(boolean flag, String color) {

        int num;

        switch (color) {

            case "black":
                num = 0;
                break;
            case "brown":
                num = 1;
                break;
            case "red":
                num = 2;
                break;
            case "orange":
                num = 3;
                break;
            case "yellow":
                num = 4;
                break;
            case "green":
                num = 5;
                break;
            case "blue":
                num = 6;
                break;
            case "violet":
                num = 7;
                break;
            case "grey":
                num = 8;
                break;
            default:
                num = 9;
        }

        return flag ? num : (int) Math.pow(10, num);
    }
}