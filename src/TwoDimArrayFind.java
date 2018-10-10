/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class TwoDimArrayFind {
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0){
            return false;
        }else{
            int column = array[0].length;
            int row = array.length;
            for(int i = 0; i < row; i++){
                if(array[i][row-1] < target){
                    continue;
                }else{
                    if(array[i][0] > target){
                        continue;
                    }else {
                        int startColumn = 0;
                        int endColumn = column-1;
                        int mid = (startColumn + endColumn)/2;
                        if(mid == 0){
                            if(array[i][0] == target){
                                return true;
                            }else{
                                continue;
                            }
                        }
                        while(startColumn < endColumn){
                            if(array[i][mid] == target){
                                return true;
                            }else {
                                if (array[i][mid] < target) {
                                    startColumn = mid + 1;
                                    mid = (startColumn + endColumn) / 2;
                                } else {
                                        endColumn = mid - 1;
                                        mid = (startColumn + endColumn) / 2;
                                }
                            }
                        }
                        if(array[i][mid] == target){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
