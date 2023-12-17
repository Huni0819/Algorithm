class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] query : queries) {
            int index1 = query[0];
            int index2 = query[1];
            
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
        return arr;
    }
}