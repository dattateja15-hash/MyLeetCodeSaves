package MaxConsecutiveOnesIII;

public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k){
        int result = 0;
        int left = 0;
        int current = 0;
        for(int right = 0;right<nums.length;right++){
            if(nums[right]==0){
                current++;
            }
            while(current>k){
                if(nums[left]==0){
                    current--;
                }
                left++;
            }
            result = Math.max(result,right-left+1);
        }
        return result;
    }

}
