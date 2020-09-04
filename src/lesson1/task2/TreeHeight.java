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
public class TreeHeight {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        bufferedReader.readLine();
        String[] array = bufferedReader.readLine().split(" ");
        List<Branch> branches = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            int number = Integer.parseInt(array[i]);
            branches.add(new Branch(i, number));
        }
        for (Branch branch : branches) {
            int parentValue = branch.parentValue;
            if (parentValue == -1) {
                branch.parent = null;
                continue;
            }
            for (Branch branch1 : branches) {
                if (branch1.value == branch.parentValue) {
                    branch.parent = branch1;
                    break;
                }
            }
        }
        int treeLength = 0;
        for (Branch branch : branches) {
            int branchLength = branch.length();
            treeLength = Math.max(treeLength, branchLength);
        }

        System.out.println(treeLength);
    }

    static class Branch {

        int value;
        int parentValue;
        Branch parent;

        Branch(int value, int parentValue) {
            this.value = value;
            this.parentValue = parentValue;
        }

        public int length() {
            if (parent == null) {
                return 1;
            } else {
                return 1 + parent.length();
            }
        }
    }
}
