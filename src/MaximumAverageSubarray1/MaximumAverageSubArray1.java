package MaximumAverageSubarray1;

public class MaximumAverageSubArray1 {

    public static double findMaxAverage(int[] nums, int k ){
        double result = 0;
        double curr = 0;
        for(int i = 0;i<k;i++){
            curr+=nums[i];
        }
        result = curr;
        for(int i = k;i<nums.length;i++){
            curr = curr + nums[i] - nums[i-k];
            result = Math.max(result,curr);
        }
        return result/k;
    }

}
