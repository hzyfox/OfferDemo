package leetcode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * create with leetcode
 * USER: husterfox
 */
public class PDD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        String[] occurNumsStr = firstLine.split(" ");
        int[] occurNum = new int[occurNumsStr.length];
        for (int i = 0; i < occurNum.length; i++) {
            occurNum[i] = Integer.valueOf(occurNumsStr[i]);
        }
        int firstNumBit = Integer.valueOf(in.nextLine());
        int secondNumBit = Integer.valueOf(in.nextLine());


        int tempA = firstNumBit;
        int tempB = secondNumBit;
        firstNumBit = Math.min(tempA, tempB);
        secondNumBit = Math.max(tempA,tempB);

        long A = 0;
        long B = 0;
        long cntA = 0;
        long cntB = 0;
        int cnt = 0;
        int index = 0;

        while(cntA<firstNumBit){
            while(occurNum[index]<=0){
                index++;
            }
            A = A*10 + index;
            cnt++;
            cntA++;
            if(cnt == occurNum[index]){
                cnt = 0;
                index++;
            }
        }
        while(cntB<secondNumBit){
            while(occurNum[index]<=0){
                index++;
            }
            B = B*10 + index;
            cnt++;
            cntB++;
            if(cnt == occurNum[index]){
                cnt = 0;
                index++;
            }
        }

        System.out.println(new BigDecimal(A).multiply(new BigDecimal(B)));


    }
}
