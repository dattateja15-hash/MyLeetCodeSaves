package MinimumValueToGetPositiveStepByStepSum;

public class MinimumValueToGetPositiveStepbyStepSum {
    //[-3,2,-3,4,2]
    //[-3,1,-4,0,2]
    public static int getMinimumSteps(int[] arr){
        int sum = 0;
        int minValue = 0;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            minValue = Math.min(minValue,sum);
        }
        return 1-minValue;
    }
}
