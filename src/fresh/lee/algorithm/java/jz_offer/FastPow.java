package fresh.lee.algorithm.java.jz_offer;

public class FastPow {

    public static double fastPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b != 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b = b >> 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("fast pow(2, 10) = " + fastPow(2.0, 10));
        System.out.println("fast pow(2, -2) = " + fastPow(2.0, -2));
    }
}
