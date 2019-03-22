import java.util.Random;

/**
 * create with jvm.heap
 * USER: husterfox
 */

public class ParallelScavengeHeapExample {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        Random random = new Random();
        int k = 5;
        while (k>=0) {
            //4MB
            // [] intArray = new int[1024*1024];
            IntObj[] intArray = new IntObj[1024*1024];
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = new IntObj(random.nextInt());
            }
            for (int i = 0; i< 10; i++){
                System.out.println(intArray[i]);
            }
            k--;
        }
        ParallelScavengeHeapExample parallelScavengeHeapExample0 = new ParallelScavengeHeapExample();
        ParallelScavengeHeapExample parallelScavengeHeapExample1 =new ParallelScavengeHeapExample();
        ParallelScavengeHeapExample.A a0  = parallelScavengeHeapExample0.new A(0);
        ParallelScavengeHeapExample.A a1 = parallelScavengeHeapExample1.new A(1);
        parallelScavengeHeapExample0.print(a1);
    }
    class  A{
        int value;
        A(int val){
            value = val;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
    public void print(A a){
        System.out.println(a);
    }

}
class IntObj{
    int value;
    IntObj(int val){
        value = val;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
