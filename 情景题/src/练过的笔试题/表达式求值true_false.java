package 练过的笔试题;

import java.util.Scanner;
import java.util.Stack;

public class 表达式求值true_false {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        String t = "true";
        String f = "false";
        String a = "and";
        String o = "or";
        boolean res = false;
        Stack<String> stack1 = new Stack<>();
        if (strings.length % 2 == 0) {
            System.out.println("error");
            return;
        }
        for (int i = 0; i < strings.length; i++) {
            if (i % 2 == 0) {
                if (!strings[i].equals(t) && !strings[i].equals(f)) {
                    System.out.println("error");
                    return;
                }
            } else {
                if (!strings[i].equals(a) && !strings[i].equals(o)) {
                    System.out.println("error");
                    return;
                }
            }
            stack1.push(strings[i]);
        }

        Stack<String> stack2 = new Stack<>();
        while (!stack1.isEmpty()) {
            if (!stack1.peek().equals(a)) {
                stack2.add(stack1.pop());
            } else {
                stack1.pop();
                String s1 = stack1.pop();
                String s2 = stack2.pop();
                boolean b1 = s1.equals(t);
                boolean b2 = s2.equals(t);
                boolean b3 = b1 && b2;
                String s3 = b3 ? "true" : "false";
                stack2.add(s3);
            }
        }
        while (!stack2.isEmpty()) {
            if (!stack2.peek().equals(o)) {
                stack1.add(stack2.pop());
            } else {
                String s1 = stack1.pop();
                stack2.pop();
                String s2 = stack2.pop();
                boolean b1 = s1.equals(t);
                boolean b2 = s2.equals(t);
                boolean b3 = b1 || b2;
                String s3 = b3 ? "true" : "false";
                stack1.add(s3);
            }
        }
        System.out.println(stack1.pop());
    }

}
