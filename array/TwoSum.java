package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum { public int[] twoSum(int[] nums, int target) {

    int[] res={-1,-1};
    Map<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<nums.length;i++){
        if(map.containsKey(target-nums[i])){
            res[0]=map.get(target-nums[i]);
            res[1]=i;
        }
        map.put(nums[i],i);//2,7

    }
    return res;
}
}


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res={-1,-1};
        Map<Integer,Integer> visited=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int compensa=target-nums[i];
            if(visited.containsKey(compensa)){
                res[0]=i;
                res[1]=visited.get(compensa);
                return res;//也可以不提前return，但题目只要求一个解，所以提前return更快
            }
            visited.put(nums[i],i);
        }
        return res;
    }
}

