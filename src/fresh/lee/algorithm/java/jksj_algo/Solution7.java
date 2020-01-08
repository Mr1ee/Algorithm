package fresh.lee.algorithm.java.jksj_algo;

public class Solution7 {

    public int reverse(int x) {
        boolean sign = ((0x80000000 & x) == 0x80000000);

        x = Math.abs(x);
        long reverse = 0;
        while (x > 0) {
            int b = x % 10;
            reverse = 10 * reverse + b;
            x = x / 10;
        }

        long result = sign ? -reverse : reverse;
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }

        return (int)result;
    }

    public static void main1(String[] args) {
        System.out.println(12345);
        System.out.println(new Solution7().reverse(12345));
        System.out.println(new Solution7().reverse(-12345));
        System.out.println(new Solution7().reverse(Integer.MIN_VALUE));
        System.out.println(new Solution7().reverse(Integer.MAX_VALUE));
    }

    public static void main(String[] args) {

        System.out.println(Double.parseDouble("1"));

        // java.lang.NumberFormatException: empty String
        //System.out.println(Double.parseDouble(""));

        // NullPointerException
        //System.out.println(Double.parseDouble(null));
        int i = 2;
        switch (i) {
            case 4:
                System.out.println(4);
            case 3:
                System.out.println(3);
            case 2:
                System.out.println(2);
            case 1:
                System.out.println(1);
            case 0:
                System.out.println(0);
            default:
                System.out.println("default");
        }
    }
}
