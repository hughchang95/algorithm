package 见过的笔试题.华为;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String[] segment = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < segment.length; ) {
            int begin = i;
            while (begin < segment.length && !segment[begin].equals("5a")) {
                begin++;
            }
            if (begin == segment.length) {
                break;
            }
            int end = begin + 1;
            while (end < segment.length && !segment[end].equals("5a")) {
                end++;
            }
            if (end == segment.length) {
                break;
            }
            int count = end - begin - 1;
            String[] content = new String[count];
            System.arraycopy(segment, begin + 1, content, 0, count);
            boolean check = check(content);
            if (check) {
                sb.append("5a").append(" ");
                for (String c : content) {
                    sb.append(c).append(" ");
                }
            }
            i = end;
        }
        System.out.println(sb.append("5a"));
    }

    public static boolean check(String[] content) {
        try {
            Integer sum = Integer.valueOf(content[content.length - 1], 16);
            int count = 0;
            for (int i = 0; i < content.length - 1; i++) {
                count++;
                if (i + 1 < content.length - 1 && content[i].equals("5b") && content[i + 1].equals("ba")) {
                    count--;
                }
                if (i + 1 < content.length - 1 && content[i].equals("5b") && content[i + 1].equals("bb")) {
                    count--;
                }
            }
            return sum == count;
        } catch (Exception e) {
            return false;
        }
    }

}