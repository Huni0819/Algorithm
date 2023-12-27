import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();

        addQueue(queue, priorities);

        return calc(queue, location);
    }

    private int calc(Queue<Integer> queue, int location) {
        int num;
        int max = getMax(queue);
        int count = 1;

        while (true) {
            num = queue.poll();

            if (num == max && location == 0) {
                return count;
            }

            if (num == max) {
                max = getMax(queue);

                count++;
            } else {
                queue.add(num);
            }

            location = location == 0 ? queue.size() - 1 : location - 1;
        }
    }

    private int getMax(Queue<Integer> queue) {
        int result = 0;

        for (Integer i : queue) {
            if (result < i) {
                result = i;
            }
        }

        return result;
    }

    private void addQueue(Queue<Integer> queue, int[] priorities) {
        for (int priority : priorities) {
            queue.offer(priority);
        }
    }

}