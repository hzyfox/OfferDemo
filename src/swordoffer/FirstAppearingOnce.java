package swordoffer;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class FirstAppearingOnce {
    LinkedHashMap<Character, Boolean> store = new LinkedHashMap<>();
    int[] hash = new int[256];
    StringBuilder builder = new StringBuilder();

    public void Insert(char ch) {
        if (store.containsKey(ch)) {
            store.put(ch, true);
        } else {
            store.put(ch, false);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char tmp : store.keySet()) {
            if (!store.get(tmp)) {
                return tmp;
            }
        }
        return '#';
    }

    public void Insert0(char ch) {
        hash[ch]++;
        builder.append(ch);
    }

    public char FirstAppearingOnce0() {
        for (int i = 0; i < builder.length(); i++) {
            if (hash[builder.charAt(i)] == 1) {
                return builder.charAt(i);
            }
        }
        return '#';
    }


}
