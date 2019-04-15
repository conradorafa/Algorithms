// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class SmallestPositiveInt {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = -1;
        Integer[] sourceArray = Arrays.stream( A ).boxed().toArray( Integer[]::new );
        TreeSet<Integer> sourceSet = new TreeSet<Integer>(Arrays.asList(sourceArray));
        Integer[] targetArray = sourceSet.toArray(new Integer[sourceSet.size()]);
        
        if(sourceSet.last() <= 0) {
            result = 1;
            
        } else {
            for(int i=1 ; i<targetArray.length; i++){
                int aux = targetArray[i]-targetArray[i-1];
                if(aux > 1){
                    result = targetArray[i-1] + 1;
                }
            }
            if(result == -1) {
                result = targetArray[targetArray.length-1]+1;
            }
        }
        return result;
    }
}

/**
This is a demo task.

Write a function:

    class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000].

**/
