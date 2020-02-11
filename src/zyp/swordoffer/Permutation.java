package zyp.swordoffer;

import java.util.ArrayList;

/**
 * @author zyp
 */
public class Permutation {
    ArrayList<String> results = new ArrayList<>();
    ArrayList<Character> curPath = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str.length()>0||str!=null) {
            findANN(str.toCharArray(), str.length());
        }
        return results;
    }

    public void findANN(char[] array,int circle){
        if(circle == 0){
            System.out.println(curPath.toString());
            results.add(String.valueOf(curPath));
            return;
        }
        for(int i = 0;i<array.length;i++){
            if(curPath.contains(array[i])){
                continue;
            }
            curPath.add(array[i]);
            findANN(array,circle-1);
            curPath.remove(curPath.size()-1);
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        String x = "abc";
        permutation.Permutation(x);
    }

}
