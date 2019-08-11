package NiuKeLeetCode;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */


public class Queen {
    private int columns[];
    private int rt2lb[];
    private int lt2rb[];
    private int queen[];
    final private int N;
    private int ansNum = 0;

    public Queen(int n) {
        N = n;
        columns = new int[N + 1];
        rt2lb = new int[2 * N + 1];
        lt2rb = new int[2 * N + 1];
        queen = new int[N + 1];
    }

    public void backtrack(int i) {
        if (i > N) {
            showAnswer();
            return;
        }
        for(int j = 1; j<=N; j++){
            if(columns[j] == 0 && rt2lb[i+j] == 0 && lt2rb[i-j+N] == 0){
                queen[i] = j;
                columns[j] = rt2lb[i+j] = lt2rb[i-j+N] = 1;
                backtrack(i+1);
                columns[j] = rt2lb[i+j] = lt2rb[i-j+N] = 0;
            }
        }
    }

    public void showAnswer() {
        System.out.println("Answer: " + ++ansNum);
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                if (queen[y] == x) {
                    System.out.print("Q");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Queen queen = new Queen(8);
        queen.backtrack(1);
    }
}


