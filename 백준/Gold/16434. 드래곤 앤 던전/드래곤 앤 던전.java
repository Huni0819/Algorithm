import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Room[] arr;
    static long attack;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        attack = Integer.parseInt(st.nextToken());

        arr = new Room[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            arr[i] = new Room(t, a, h);
        }

        System.out.println(solution());
    }

    private static long solution() {
        long high = Long.MAX_VALUE;
        long low = 1l;

        long prev = high;
        boolean check = true;
        while (low <= high) {
            long middle = low + (high - low) / 2;

            // middle 값으로 클리어가 되면 middle 이상 값은 범위에서 제거
            if (checkClear(middle)) {
                high = middle - 1l;
                prev = middle;
                check = true;
            } else { // middle 값으로 클리어가 불가능 하다면 middle 이하 값은 범위에서 제거
                low = middle + 1l;
                check = false;
            }
        }

        if (!check) {
            return prev;
        }

        return low;
    }

    private static boolean checkClear(long number) {

        long hp = number;
        long atk = attack;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].t == 1) { // 몬스터면
                long count = arr[i].h / atk;

                if (arr[i].h % atk == 0 && arr[i].h > 1) {
                    count--;
                }

                hp -= count * arr[i].a;

                if (hp <= 0) {
                    return false;
                }
            } else { // 포션이면
                hp = Math.min(number, hp + arr[i].h);
                atk += arr[i].a;
            }
        }

        return true;
    }
}

class Room {

    // t == 1 -> 공격력이 a, 생명력이 h인 몬스터
    // t == 2 -> 공격력을 a, 생명력을 h만큼 증가시켜주는 포션
    int t;
    int a;
    int h;

    public Room(int t, int a, int h) {
        this.t = t;
        this.a = a;
        this.h = h;
    }
}