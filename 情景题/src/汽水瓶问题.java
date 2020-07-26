import java.util.Scanner;

public class 汽水瓶问题 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num==0){
                break;
            }
            int sum = 0;
            while (num >= 3) {
                int get = num / 3;
                int last = num % 3;
                sum += get;
                num = get + last;
                if (num == 2) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}



