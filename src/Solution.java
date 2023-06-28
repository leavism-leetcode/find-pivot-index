public class Solution {
    public static int originalPivotIndex(int[] nums) {
        int lhs = 0;
        int rhs = 0;
        int result = -1;

        for (int i = 1; i < nums.length; i++) {
            rhs += nums[i];
        }

        for(int i = 1; i <= nums.length; i++) {
            if (lhs == rhs) {
                // the edge case where the pivot index is the first element
                if (i == 1) { result = 0; break; }

                result = i - 1;
                break;
            }

            if (i != nums.length) {
                // the edge case where the pivot index is the last element
                lhs += nums[i - 1];
                rhs -= nums[i];
            } else {
                lhs += nums[i - 1];
                rhs -= nums[i - 1];
            }

        }

        return result;
    }

    public static int pivotIndex(int[] nums) {
        int lhs = 0;
        int rhs = 0;

        for (int num : nums) { rhs += num; }
        rhs -= nums[0];

        for(int i = 1; i <= nums.length; i++){
            if (lhs == rhs) {
                return i - 1;
            }

            if (i == nums.length) {
                // edge case when pivot index is last element
                lhs += nums[i - 1];
                rhs -= nums[i - 1];
            } else {
                // when pivot index is not last element
                lhs += nums[i - 1];
                rhs -= nums[i];
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1,-1,0,0,-1,-1};
        System.out.println(pivotIndex(arr));
    }
}