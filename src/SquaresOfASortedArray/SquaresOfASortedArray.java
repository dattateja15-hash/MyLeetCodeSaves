package SquaresOfASortedArray;

public class SquaresOfASortedArray {

    public static int[] sortedSquares(int[] nums){
        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            nums[i] = nums[i]*nums[i];
        }
        int last = result.length-1;
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            if(nums[left]<nums[right]){
                result[last] = nums[right];
                right--;
            }
            else{
                result[last] = nums[left];
                left++;
            }
            last--;
        }
        return result;
    }

}
