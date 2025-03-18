import KRadiusSubarrayAverages.KRadiusSubarrayAverage;
import MaxConsecutiveOnesIII.MaxConsecutiveOnesIII;
import MaximumAverageSubarray1.MaximumAverageSubArray1;
import ReverseString.ReverseString;
import SquaresOfASortedArray.SquaresOfASortedArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(SquaresOfASortedArray.sortedSquares(nums)));

    }

    //[10,4,-8,7] = [10,14,6,13]
    //[7,4,3,9,1,8,5,2,6]
    //[7,11,14,23,24,32,37,39,45]

    public static int waysToSplit(int[] nums){
        int ans = 0;
        int total = 0;
        for(int i = 0;i<nums.length;i++){
            total+=nums[i];
        }
        int leftSection = 0;
        for(int i = 0;i<nums.length;i++){
            leftSection+=nums[i];
            int rightSection = total - leftSection;
            if(leftSection>rightSection){
                ans++;
            }
        }

        return ans;
    }

    public boolean[] answerQueries(int[] nums, int[][] queries, int limit){
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        boolean[] ans = new boolean[queries.length];
        for(int i = 0;i<queries.length;i++){
            int x = queries[i][0];
            int y = queries[i][1];
            int curr = prefix[y] - prefix[x] + nums[x];
            ans[curr] = curr<limit;
        }
        return ans;
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