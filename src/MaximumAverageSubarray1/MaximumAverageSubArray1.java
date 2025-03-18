package MaximumAverageSubarray1;

public class MaximumAverageSubArray1 {

    public static double findMaxAverage(int[] nums, int k ){
        double result = 0;
        double current = 0;
        for(int i = 0;i<k;i++){
            current += nums[i];
        }
        result = current;
        for(int i = k;i<nums.length;i++){
            current += nums[i] - nums[i-k];
            result = Math.max(current,result);
        }
        return result/(double)k;
    }

}
