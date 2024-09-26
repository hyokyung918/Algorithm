class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, String.valueOf(n % k));
            n /= k;
        }
        String s = sb.toString();
        String[] strs = s.split("0");
        int answer = 0;
        
        for (String str : strs) {
            if (str.equals("") || str.equals("1")) continue;
            
            long num = Long.parseLong(str);
            boolean isPrime = true;
            for (int i=2; i<=Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false; 
                    break;
                }
            }
            if (isPrime) answer++;
        }
        return answer;
    }
}