package fresh.lee.algorithm.java.jz_offer;

import fresh.lee.algorithm.java.Log;

public class DuplicateNumber {

    static int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};

    public static void main(String[] args) {
        System.out.println("duplicate number is");
        System.out.println(duplicate(arr));
    }

    public static int duplicate(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return -1;
        }

        for (int num : numbers) {
            if (num < 0 || num > numbers.length - 1) {
                return -1;
            }
        }
        Log.getInstance().print(arr);

        int exchangeCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }

                //swap number[i] and numbers[numbers[i]]
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
                exchangeCount++;
            }
        }

        Log.getInstance().print(exchangeCount);
        return -1;
    }

}
