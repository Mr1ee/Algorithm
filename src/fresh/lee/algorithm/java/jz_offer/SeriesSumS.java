package fresh.lee.algorithm.java.jz_offer;

import java.util.Scanner;

public class SeriesSumS {

    public static void seriesSumS(int sum) {
        if (sum < 1)
            System.out.println("sum must is a positive number!");
        int small = 1;
        int big = 2;
        int middle = (sum + 1) >> 1;
        int currentSum = small + big;
        while (small < middle) {
            if (currentSum == sum) {
                printResult(small, big);
            }

            while (currentSum > sum && small < middle) {
                currentSum -= small;
                small++;
                if (currentSum == sum) {
                    printResult(small, big);
                }
            }
            big++;
            currentSum += big;
        }
    }

    public static void printResult(int small, int big) {
        for (int i = small; i <= big; i++) {
            System.out.print(" " + i);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum  =input.nextInt();
        seriesSumS(sum);
    }
}
