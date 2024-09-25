class Solution {
    
    public int[][] arr;
    public int[] answer = {0, 0};
    
    public int[] solution(int[][] arr) {
        int size = arr.length;
        this.arr = arr;
        
        search(0, 0, size);
        return answer;
    }
    
    public void search(int sx, int sy, int size) {
        
        int x = arr[sx][sy];
        boolean isPossible = true;
        for (int i=sx; i<sx+size; i++) {
            for (int j=sy; j<sy+size; j++) {
                if (arr[i][j] != x) {
                    isPossible = false;
                    break;
                }
            }
        }
        if (isPossible) {
            answer[x]++;
            return;
        } 
        search(sx, sy, size/2);
        search(sx, sy+(size/2), size/2);
        search(sx+(size/2), sy, size/2);
        search(sx+(size/2), sy+(size/2), size/2);
    }
}