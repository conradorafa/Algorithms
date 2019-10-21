import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class ShiftString {

    /*
     * Complete the 'getShiftedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER leftShifts
     *  3. INTEGER rightShifts
     */

    public static String getShiftedString(String s, int leftShifts, int rightShifts) {
    // Write your code here
        char[] left = solutionToLeftRotation(s.toCharArray(), leftShifts);
        char [] right = solutionToRight(left, rightShifts);

        return String.copyValueOf(right);


    }

    private static char[] solutionToRight(char[] A, int K) {
        for (int j=0; j<K; j++){
            char temp = A[A.length-1];
            for(int i=A.length-1; i>0; i--){
                A[i] = A[i-1];
            }
            A[0] = temp;
        }
        return A;
    }

    private static char[] solutionToLeftRotation(char[] A, int K) {
        for (int j=0; j<K; j++){
            char temp = A[0];
            for(int i=0; i<A.length-1; i++){
                A[i] = A[i+1];
            }
            A[A.length-1] = temp;
        }
        return A;
    }

}