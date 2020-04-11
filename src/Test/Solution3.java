package Test;

import java.util.*;


public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int repeat = scanner.nextInt();
        scanner.nextLine();
        String number = scanner.nextLine();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = number.charAt(i) - '0';
        }
        //查找要变成几 0到9中的一个

        //key 为 变动的和 value为 变动的数字集合
        HashMap<Integer, ArrayList<Integer>> result = new HashMap<>();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = Math.abs(nums[j] - i);
            }
            Arrays.sort(tmp);
            int sum = 0;
            for (int j = 0; j < repeat; j++) {
                sum += tmp[j];
            }
            if (result.containsKey(sum)) {
                result.get(sum).add(i);
            } else {
                ArrayList<Integer> tmpList = new ArrayList<>();
                tmpList.add(i);
                result.put(sum, tmpList);
            }
            min = Math.min(sum, min);
        }

        ArrayList<Integer> todo = result.get(min);
        String ans = "x";
        for(int target: todo){
            String tmpstr = getResult(nums, target, repeat);
            if(ans.compareTo(tmpstr)>0){
                ans = tmpstr;
            }
        }
        System.out.println(min);
        System.out.println(ans);

    }

    static class Data {
        int index;
        int elem;

        public Data(int index, int elem) {
            this.index = index;
            this.elem = elem;
        }
    }

    public static String getResult(int[] nums, int target, int repeat) {
        StringBuilder res = new StringBuilder();
        Data[] datas = new Data[nums.length];
        for (int i = 0; i < nums.length; i++) {
            datas[i] = new Data(i, Math.abs(nums[i] - target));
        }
        Arrays.sort(datas, Comparator.comparingInt(a -> a.elem));

        ArrayList<Data> toDoData = new ArrayList<>();
        int preelem = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == repeat - 1) {
                toDoData.add(datas[i]);
                preelem = datas[i].elem;
                continue;
            }
            if (i < repeat) {
                preelem = datas[i].elem;
                continue;
            }
            if (datas[i].elem == preelem) {
                toDoData.add(datas[i]);
            }
        }

        String ans = "x";
        for (Data todo0 : toDoData) {
            StringBuilder tmpAns = new StringBuilder();
            for(int i = 0; i<nums.length; i++){
                tmpAns.append(nums[i]);
            }
            for(int i = 0; i<repeat-1; i++){
                tmpAns.replace(datas[i].index, datas[i].index+1 ,String.valueOf(target));
            }
            tmpAns.replace(todo0.index, todo0.index+1, String.valueOf(target));
            if(ans.compareTo(tmpAns.toString()) > 0){
                ans = tmpAns.toString();
            }
        }
        return ans;
    }

}
