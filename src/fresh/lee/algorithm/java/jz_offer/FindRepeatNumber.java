package fresh.lee.algorithm.java.jz_offer;

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int pos = 0;
        int find = -1;
        while (pos < nums.length) {
            if (nums[pos] != pos) {
                int tmp = nums[pos];
                if (tmp == nums[tmp]) {
                    find = tmp;
                }
                nums[pos] = nums[tmp];
                nums[tmp] = tmp;
            } else {
                pos++;
            }
        }

        return find;
    }
}
