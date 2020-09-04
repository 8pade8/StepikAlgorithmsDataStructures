package lesson1.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Time limit exceeded
 */
public class SimpleTreeHeight {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        bufferedReader.readLine();
        String[] array = bufferedReader.readLine().split(" ");
        List<Integer> numbList = new ArrayList<Integer>();
        for (String s : array) {
            numbList.add(Integer.parseInt(s));
        }
        for (int i = 0; i < numbList.size(); i++) {
            if (numbList.get(i) == -1) {
                System.out.println(height(numbList, i));
            }
        }
    }

    public static int height(List<Integer> array, int root) {
        List<Integer> sons = new ArrayList<Integer>();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == root) {
                sons.add(i);
            }
        }
        int maxHeight = 0;
        for (Integer son : sons) {
            maxHeight = Math.max(height(array, son), maxHeight);
        }
        return 1 + maxHeight;
    }
}
