public class PerfectNumbers {
    public static void main(String[] args) {
        int n = 10000; // check up to 1000
        System.out.println("Perfect numbers up to " + n + ":");

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum = sum + j;
                }
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
    }
}
