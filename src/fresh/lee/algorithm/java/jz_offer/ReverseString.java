package fresh.lee.algorithm.java.jz_offer;

public class ReverseString {

    public static String reverseString(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("parameter s must nut null!");
        }
        String s1 = reverse(s);
        String[] array = s1.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(reverse(array[i]));
            if (i != array.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String leftRotateString(String s, int index) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("parameter s must nut null!");
        }

        if (index > s.length()) {
            throw new IllegalArgumentException("s length must bigger than index!");
        }

        return reverse(reverse(s.substring(0, index)) + reverse(s.substring(index)));


    }

    public static String reverse(String s) {
        StringBuilder res = new StringBuilder(s);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "I am a students.";
        System.out.println(reverseString(s));

        String s1 = "abcdefg";
        System.out.println(leftRotateString(s1, 2));

    }
}
