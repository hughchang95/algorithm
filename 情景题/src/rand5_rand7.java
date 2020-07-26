public class rand5_rand7 {
    public static int rand5() {
        return (int) (Math.random() * 5);
    }

    public static int rand7() {
        int x;
        do {
            x = (rand5() - 1) * 5 + rand5();
        } while (x > 21);
        return x % 7 + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(rand5());
            System.out.println("------");
            System.out.println(rand7());
        }
    }
}
