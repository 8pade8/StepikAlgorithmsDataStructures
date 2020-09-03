package lesson1.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BracketsInCode {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        char[] charArray = s.toCharArray();
        HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            put('}', '{');
            put(')', '(');
            put(']', '[');
        }};
        List<Character> list = new ArrayList<>();
        list.addAll(map.keySet());
        list.addAll(map.values());
        Stack<Character> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (list.contains(c)) {
                if (map.containsValue(c)) {
                    stack.push(c);
                    indexStack.push(i+1);
                } else {
                    if (stack.isEmpty()) {
                        System.out.println(i+1);
                        return;
                    } else {
                        indexStack.pop();
                        if (!stack.pop().equals(map.get(c))) {
                            System.out.println(i+1);
                            return;
                        }
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Success");
        }
        else {
            System.out.println(indexStack.pop());
        }
    }
}
