class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        for (int i=0; i<10; i++) {
            answer += i;
        }
        for (int n : numbers) {
            answer -= n;
        }
        return answer;
    }
}