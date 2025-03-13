package SquaresOfASortedArray;

public class SquaresOfASortedArray {

    public static int[] sortedSquares(int[] nums){
        int result[] = new int[nums.length];
        int n = nums.length ;
        int left = 0;
        int right = n - 1;
        int index = n-1;
        while(left<=right){
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if(leftSquare > rightSquare){
                result[index] = leftSquare;
                left++;
            }
            else{
                result[index] = rightSquare;
                right--;
            }
            index--;
        }

        return result;
    }

}
