package zyp.leetcode.first100;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zyp
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        g.generateParenthesis(3);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        generateHelper("",0,0,n,res);
        return res;
    }

    public void generateHelper(String s,int l,int r,int n,List<String> res){
        if(l>n||r>n){
            return;
        }
        if(l==n&&r==n){
            res.add(s);
        }
        if(l>=r){
            generateHelper(s+"(",l+1,r,n,res);
            generateHelper(s+")",l,r+1,n,res);
        }
    }
}
