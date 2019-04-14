package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class TouTiao {
    public static void main(String[] args) {
        int[] array = {2,3,4,5};
        new TouTiao().jump(array);
    }

    public void jump(int[] energy) {
        if (energy == null || energy.length <= 2) {
            System.out.println(0);
            return;
        }
        double initial = 0;
        for (int i = energy.length - 2; i >= 1; i--) {
            initial = Math.ceil((initial + energy[i]) / 2.0d);
        }
        System.out.println((int) Math.ceil(initial));
    }
}
