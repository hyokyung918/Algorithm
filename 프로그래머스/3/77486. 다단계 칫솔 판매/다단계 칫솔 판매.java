import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        HashMap<String, Integer> enrollMap = new HashMap<>();
        enrollMap.put("-", -1);
        for (int i=0; i<enroll.length; i++) {
            enrollMap.put(enroll[i], i);
        }
        
        HashMap<String, String> referralMap = new HashMap<>();
        for (int i=0; i<referral.length; i++) {
            String name = enroll[i];
            String refName = referral[i];
            referralMap.put(name, refName);
        }
        
        for (int i=0; i<seller.length; i++) {
            int sellAmount = amount[i] * 100;
            
            String sellerName = seller[i];
            int sellerNum = enrollMap.get(sellerName);
            String referralName = referralMap.get(sellerName);
            int referralNum = enrollMap.get(referralName);
            
            while (sellAmount>0 && referralNum>-1) {
                answer[sellerNum] += sellAmount - (sellAmount/10);
                sellAmount /= 10;
                sellerName = referralName;
                sellerNum = referralNum;
                referralName = referralMap.get(sellerName);
                referralNum = enrollMap.get(referralName);
            }
            answer[sellerNum] += sellAmount - (sellAmount/10);
        }
        
        return answer;
    }
}