package lesson1.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Good Resolve
 */
public class FastTreeHeight {

    static HashMap<Integer, Integer> lengths;
    static List<Integer> numbList;

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        bufferedReader.readLine();
        String[] array = bufferedReader.readLine().split(" ");
        numbList = new ArrayList<Integer>();
        for (String s : array) {
            numbList.add(Integer.parseInt(s));
        }
        lengths = new HashMap<Integer, Integer>();

            for (Integer integer : numbList) {
                height(integer);
            }
        System.out.println(Collections.max(lengths.values()));
    }

    private static int height(Integer integer) {
        if (integer == -1) {
            return 1;
        }
        Integer parent = numbList.get(integer);
        int length;
        if (lengths.containsKey(parent)) {
            length =  1 + lengths.get(parent);
        } else {
            length =  1 + height(parent);
        }
        lengths.put(integer, length);
        return length;
    }
}
