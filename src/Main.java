import MaximumAverageSubarray1.MaximumAverageSubArray1;
import SquaresOfASortedArray.SquaresOfASortedArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(SquaresOfASortedArray.sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(findLength("11001011"));
        System.out.println(numSubArrayProductLessThanK(new int[]{10,5,2,6},100));
        System.out.println(findBestSubArray(4,new int[]{3,-1,4,12,-8,5,6}));
        System.out.println(MaximumAverageSubArray1.findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }

    public static int findLength(String s){
        int result = 0;
        int left = 0;
        int curr = 0;
        for(int right = 0;right < s.length();right++){
            if(s.charAt(right)=='0'){
                curr++;
            }
            while(curr>1){
                if(s.charAt(left)=='0'){
                    curr--;
                }
                left++;
            }
            result = Math.max(curr,right-left+1);
        }

        return result;
    }

    public static int numSubArrayProductLessThanK(int[] nums, int k){
        if(k<=1){
            return 0;
        }
        int result = 0;
        int left = 0;
        int curr = 1;
        for(int right = 0;right<nums.length;right++){
            curr *= nums[right];
            if(curr>=k){
                curr /= nums[left];
                left++;
            }
            result += right - left+1;
        }
        return result;
    }

    public static int findBestSubArray(int k,int [] nums){
        int ans = 0;
        int curr = 0;
        for(int i = 0;i<k;i++){
            curr+=nums[i];
        }
        ans = curr;
        for(int i = k;i<nums.length;i++){
            curr+=nums[i] - nums[i-k];
            ans = Math.max(ans,curr);
        }
        return ans;
    }
}