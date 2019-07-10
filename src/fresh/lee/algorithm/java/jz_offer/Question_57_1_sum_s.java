package fresh.lee.algorithm.java.jz_offer;

public class Question_57_1_sum_s {

    static int[] arr = new int[]{1, 2, 4, 7, 11, 15};

    public static void main(String[] args) {
        System.out.println("duplicate number is");
        twoSum(arr, 15);

        System.out.println(sequenceSum(13) ? "found!" : "not found!");
    }

    public static void twoSum(int[] arr, int sum) {
        //remember always check parameters first !!!
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("wrong parameters! array must not empty");
        }

        int ahead = arr.length - 1;
        int behind = 0;
        while (ahead > behind) {
            //long avoid overflow !!!
            long curSum = arr[ahead] + arr[behind];
            // find
            if (curSum == sum) {
                System.out.println("result is " + arr[behind] + " + " + arr[ahead]);
                return;
            } else if (curSum > sum) {
                ahead--;
            } else {
                behind++;
            }
        }
    }

    /**
     * @param sum sum > 0
     */
    public static boolean sequenceSum(int sum) {
        //remember always check parameters first !!!
        if (sum < 3) {
            throw new IllegalArgumentException("wrong parameters! array must not empty");
        }

        boolean find = false;

        int small = 1;
        int big = 2;
        int middle = (sum + 1) / 2;
        int curSum = small + big;

        while (small < middle) {
            if (curSum == sum) {
                find = true;
                printSequenceNumber(small, big);
            }

            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    find = true;
                    printSequenceNumber(small, big);
                }
            }

            big++;
            curSum += big;
        }

        return find;
    }

    private static void printSequenceNumber(int small, int big) {
        for (int i = small; i <= big; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
