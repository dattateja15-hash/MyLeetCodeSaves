package KRadiusSubarrayAverages;

import java.util.Arrays;

public class KRadiusSubarrayAverage {



    public static int[] findAverages(int[] nums, int k) {
        //[7,4,3,9,1,8,5,2,6]
        //[7,11,14,23,24,32,37,39,45] k = 3
        int[] result = new int[nums.length];
        int[] prefixSums = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            result[i] = -1;
        }
        int windowSize = (2*k+1);
        if(k>windowSize){
            return result;
        }
        prefixSums[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            prefixSums[i] = nums[i] + prefixSums[i-1];
        }
        for(int i = k;i<nums.length-k;i++){
            int leftBound = i - k;
            int rightBound = i+k;
            long sum = prefixSums[rightBound+1] - prefixSums[leftBound];
            int avg = (int)(sum/(windowSize));
            result[i] = avg;
        }
        return result;
    }

}
