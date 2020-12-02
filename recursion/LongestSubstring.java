package recursion;

import java.util.Arrays;

//leetcode395
public class LongestSubstring {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return false;
        }

        int sum= Arrays.stream(nums).sum();
        if(sum%k!=0) return false;
        int target= sum/k;//subsum

        Arrays.sort(nums);
        int beginIndex=nums.length-1;
        if(nums[beginIndex]>target){
            return false;
        }
        while(beginIndex>=0 && nums[beginIndex]==target){
            beginIndex--;//自成一组
            k--;
        }

        return partition(new int[k],nums,beginIndex,target);//child problem
    }
    boolean partition(int[]subsets,int[] nums,int index, int target){
        //base case
        if(index<0) return true;

        //recursion rule
        int selected=nums[index];
        for(int i=0;i<subsets.length;i++){ //对每一个subset来说，尝试放入
            if(subsets[i]+selected<=target){ //if 小于目标，还可以放入
                subsets[i]+=selected;
                if(partition(subsets,nums,index-1,target)){
                    return true;//？？？如果成功放入subset中，就返回true
                }
                subsets[i]-=selected;//如果不能的话，就减掉
            }
        }
        return false;
    }

}
