package zyp.swordoffer;

import java.util.ArrayList;

/**
 * @author zyp
 */
public class CutRope {

    public static void main(String[] args) {
        CutRope cutRope = new CutRope();
        cutRope.cutRope(8);
    }
    public int cutRope(int target) {
        ArrayList<Integer> curPath = new ArrayList<>();
        for(int i=2;i<=target;i++){
            if(i==2){
                curPath.add(1);
                curPath.add(1);
                continue;
            }
            int newValue = 0;
            if(curPath.get(curPath.size()-1)<=curPath.get(curPath.size()-2)){
                newValue = curPath.remove(curPath.size()-1)+1;
            }else {
                newValue = curPath.remove(curPath.size()-2)+1;
            }
            if (newValue < 4) {
                curPath.add(newValue);
            } else {
                curPath.add(newValue / 2);
                curPath.add(newValue / 2);
            }
        }
        int product = 1;
        for (int x : curPath) {
            product *= x;
        }
        Double q = 1.0;
        int v = q.intValue();
        System.out.println(product);
        return product;
    }
}
