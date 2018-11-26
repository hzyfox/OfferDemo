import java.util.ArrayList;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class DICARER {
    public static void DiCarEr() {
        ArrayList<ArrayList<Integer>> originalData = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(11);
        list1.add(111);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(22);
        list2.add(222);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(33);
        list3.add(333);
        ArrayList<Integer> result = new ArrayList<>();
        originalData.add(list1);
        originalData.add(new ArrayList<Integer>());
        originalData.add(list2);
        originalData.add(list3);
        originalData.add(new ArrayList<Integer>());

        caculateDiCarEr(originalData, result, 0);
    }

    public static void caculateDiCarEr(ArrayList<ArrayList<Integer>> originalData, ArrayList<Integer> result, int listIndex) {
        if (listIndex == originalData.size()) {
            return;
        }
        if (originalData.get(listIndex).size() == 0) {
            if (listIndex == originalData.size() - 1) {
                System.out.println(result.toString());
            } else {
                caculateDiCarEr(originalData, result, listIndex + 1);
            }
        }
        for (int i = 0; i < originalData.get(listIndex).size(); i++) {
            int size = result.size();
            result.add(originalData.get(listIndex).get(i));
            if (listIndex == originalData.size() - 1) {
                System.out.println(result.toString());
                result.remove(size);
                continue;
            }
            caculateDiCarEr(originalData, result, listIndex + 1);
            result.remove(size);
        }
    }

    public static void main(String[] args) {
        DiCarEr();
    }

}
